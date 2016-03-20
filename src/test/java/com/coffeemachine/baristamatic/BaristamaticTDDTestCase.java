package com.coffeemachine.baristamatic;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

import org.junit.Test;

public class BaristamaticTDDTestCase {

	@Test
	public void testCustomDrinkType() {
		DrinkType drinkType = DrinkType.getDrinkType(7);
		assertNotNull(drinkType);
	}

	@Test
	public void testCustomDrinkTypeName() {
		DrinkType drinkType = DrinkType.getDrinkType(7);
		assertTrue(drinkType == DrinkType.CUSTOM);
	}

	@Test
	public void testGetCustomDrinkIngredientInvalid4() {
		String data = "Coffee, 1\nInvalidInput, 1\nq"; // Invalid input, no such
														// ingredient
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> ingredients = BaristamaticTest.getCustomDrinkIngredient();
			assertTrue(ingredients.size() == 1);
			scanner.close();
		} finally {
			System.setIn(stdin);

		}
	}

	@Test
	public void testGetCustomDrinkIngredientInvalid1() {
		String data = "Coffee,11\nCocoa, 1\nq";// Invalid input Coffee quantity
												// more than 9
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> ingredients = BaristamaticTest.getCustomDrinkIngredient();
			assertTrue(ingredients.size() == 1);
			scanner.close();
		} finally {
			System.setIn(stdin);

		}
	}

	@Test
	public void testGetCustomDrinkIngredientInvalid2() {
		String data = "\nq"; // Invalid input empty
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> ingredients = BaristamaticTest.getCustomDrinkIngredient();
			assertTrue(ingredients.size() == 0);
			scanner.close();
		} finally {
			System.setIn(stdin);

		}
	}

	@Test
	public void testGetCustomDrinkIngredientInvalid3() {
		String data = "Coffee 8\nq";// Invalid input missing a comma
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> ingredients = BaristamaticTest.getCustomDrinkIngredient();
			assertTrue(ingredients.size() == 0);
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}

	@Test
	public void testGetCustomDrinkIngredientInvalid5() {
		String data = "Coffee, 8 Cocoa , 3\nq";// Invalid input missing a new
												// line between both input
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> ingredients = BaristamaticTest.getCustomDrinkIngredient();
			assertTrue(ingredients.size() == 0);
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}

	@Test
	public void testGetCustomDrinkIngredientValid() {
		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> ingredients = BaristamaticTest.getCustomDrinkIngredient();
			assertTrue(ingredients.size() == 3);

			CustomDrinkIngredient ingredient = ingredients.get(0);
			assertTrue(ingredient.getIngredient().equals(Ingredient.COFFEE) && ingredient.getQuantity() == 8);
			ingredient = ingredients.get(1);
			assertTrue(ingredient.getIngredient().equals(Ingredient.COCOA) && ingredient.getQuantity() == 3);
			ingredient = ingredients.get(2);
			assertTrue(ingredient.getIngredient().equals(Ingredient.ESPRESSO) && ingredient.getQuantity() == 1);

			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}

	@Test
	public void testCustomRecipeBuildDirector() {

		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> customIngredients = BaristamaticTest.getCustomDrinkIngredient();

			Menu menu = new Menu();
			Drink drink =  menu.makeCustomDrink(customIngredients);
			 
			DrinkRecipe recipe = drink.getDrinkRecipe();

			boolean flag = true;

			for (Entry<Ingredient, Integer> item : recipe) {
				System.out.println(item.getKey() + " " + item.getValue());
				if (!(item.getKey().equals(Ingredient.COCOA) && item.getValue() == 3)
						&& !(item.getKey().equals(Ingredient.COFFEE) && item.getValue() == 8)
						&& !(item.getKey().equals(Ingredient.ESPRESSO) && item.getValue() == 1))
					flag = false;
			}
			assertTrue(flag);
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}

	@Test
	public void testCustomRecipeCost() throws ParseException {

		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> customIngredients = BaristamaticTest.getCustomDrinkIngredient();
			Menu menu = new Menu();
			Drink drink =  menu.makeCustomDrink(customIngredients);
			 
			DrinkRecipe recipe = drink.getDrinkRecipe();

			DecimalFormat df = new DecimalFormat("0.00");
			String formate = df.format((Ingredient.COFFEE.getCost() * 8) + (Ingredient.COCOA.getCost() * 3)
					+ (Ingredient.ESPRESSO.getCost() * 1));
			double finalValue = (Double) df.parse(formate);

			assertTrue(recipe.getCost() == finalValue);
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}
	
	@Test
	public void testCustomDrinkBuildable() { 
		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> customIngredients = BaristamaticTest.getCustomDrinkIngredient();

			Menu menu = new Menu();
			Drink drink =  menu.makeCustomDrink(customIngredients);
					
			assertTrue(drink.isBuildable(new Inventory()));
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}
	
	@Test
	public void testCustomDrinkNotBuildable() { 
		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> customIngredients = BaristamaticTest.getCustomDrinkIngredient();

			Menu menu = new Menu();
			Drink drink =  menu.makeCustomDrink(customIngredients);
			
			Inventory inventory = new Inventory();
			inventory.deductInventory(Ingredient.COFFEE, 10);
			
			assertTrue(drink.isBuildable(inventory) == false);
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}
	
	@Test
	public void testDispenseCustomDrink() throws OutOfStockException { 
		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> customIngredients = BaristamaticTest.getCustomDrinkIngredient();
 
			BaristamaticMachine coffeeMachine = new BaristamaticMachine();
			coffeeMachine.dispense(DrinkType.CUSTOM, customIngredients); 
			 
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}
	
	@Test
	public void testBuildCustomDrink() throws OutOfStockException { 
		String data = "Coffee, 8\n Cocoa, 3\n Espresso, 1\nq";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			ArrayList<CustomDrinkIngredient> customIngredients = BaristamaticTest.getCustomDrinkIngredient();
 
			Menu menu = new Menu();
			Drink drink =  menu.makeCustomDrink(customIngredients);
			
			Inventory inventory = new Inventory();
			
			drink.build(inventory);
			
			assertTrue(inventory.getInventory(Ingredient.COFFEE) == 2);
			assertTrue(inventory.getInventory(Ingredient.COCOA) == 7);
			assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 9);
			scanner.close();
		} finally {
			System.setIn(stdin);
		}
	}
}
