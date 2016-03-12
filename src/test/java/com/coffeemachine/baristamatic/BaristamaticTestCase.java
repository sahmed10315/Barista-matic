package com.coffeemachine.baristamatic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaristamaticTestCase {

	@Test
	public void testbuildCoffee() {

		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();

		// Since recipe of coffee is coffee 3, cream 1, and sugar 1 for ingredients
		// we check after building the drink, inventory has been updated correctly
		Drink coffee = menu.getDrink(DrinkType.COFFEE);
		coffee.build(inventory);
		assertTrue(inventory.getInventory(Ingredient.COFFEE) == 7);
		assertTrue(inventory.getInventory(Ingredient.CREAM) == 9);
		assertTrue(inventory.getInventory(Ingredient.SUGAR) == 9);
		assertTrue(inventory.getInventory(Ingredient.COCOA) == 10);
		assertTrue(inventory.getInventory(Ingredient.DECAF_COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 10);
		assertTrue(inventory.getInventory(Ingredient.FOAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.STEAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.WHIPPED_CREAM) == 10);
	}
	
	@Test
	public void testbuildDecafCoffee() {

		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();
 
		// Since recipe of decaf coffee is decaf coffee 3, cream 1, and sugar 1 for ingredients
		// we check after building the drink, inventory has been updated correctly
		Drink decafCoffee = menu.getDrink(DrinkType.DECAF_COFFEE);
		decafCoffee.build(inventory);
		assertTrue(inventory.getInventory(Ingredient.COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.CREAM) == 9);
		assertTrue(inventory.getInventory(Ingredient.SUGAR) == 9);
		assertTrue(inventory.getInventory(Ingredient.COCOA) == 10);
		assertTrue(inventory.getInventory(Ingredient.DECAF_COFFEE) == 7);
		assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 10);
		assertTrue(inventory.getInventory(Ingredient.FOAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.STEAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.WHIPPED_CREAM) == 10);
	}
	
	@Test
	public void testbuildCaffeLatte() {

		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();

		// Since recipe of caffe latte is  espresso 2, and steamed milk 1 for ingredients
		// we check after building the drink, inventory has been updated correctly
		Drink caffeLatte = menu.getDrink(DrinkType.CAFFE_LATTE);
		caffeLatte.build(inventory);
		assertTrue(inventory.getInventory(Ingredient.COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.CREAM) == 10);
		assertTrue(inventory.getInventory(Ingredient.SUGAR) == 10);
		assertTrue(inventory.getInventory(Ingredient.COCOA) == 10);
		assertTrue(inventory.getInventory(Ingredient.DECAF_COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 8);
		assertTrue(inventory.getInventory(Ingredient.FOAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.STEAMED_MILK) == 9);
		assertTrue(inventory.getInventory(Ingredient.WHIPPED_CREAM) == 10);
	}
	
	@Test
	public void testbuildCaffeAmericano() {

		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();
		
		// Since recipe of caffe americano is  espresso 3 for ingredients
		// we check after building the drink, inventory has been updated correctly
		Drink caffeAmericano = menu.getDrink(DrinkType.CAFFE_AMERICANO);
		caffeAmericano.build(inventory);
		assertTrue(inventory.getInventory(Ingredient.COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.CREAM) == 10);
		assertTrue(inventory.getInventory(Ingredient.SUGAR) == 10);
		assertTrue(inventory.getInventory(Ingredient.COCOA) == 10);
		assertTrue(inventory.getInventory(Ingredient.DECAF_COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 7);
		assertTrue(inventory.getInventory(Ingredient.FOAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.STEAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.WHIPPED_CREAM) == 10);
	}
	
	@Test
	public void testbuildCaffeMocha() {

		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();

		// Since recipe of caffe mocha is  cocoa 1, espresso 1, steamed milk 1, and whipped cream 1 for ingredients
		// we check after building the drink, inventory has been updated correctly
		Drink cafeMocha = menu.getDrink(DrinkType.CAFFE_MOCHA);
		cafeMocha.build(inventory);
		assertTrue(inventory.getInventory(Ingredient.COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.CREAM) == 10);
		assertTrue(inventory.getInventory(Ingredient.SUGAR) == 10);
		assertTrue(inventory.getInventory(Ingredient.COCOA) == 9);
		assertTrue(inventory.getInventory(Ingredient.DECAF_COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 9);
		assertTrue(inventory.getInventory(Ingredient.FOAMED_MILK) == 10);
		assertTrue(inventory.getInventory(Ingredient.STEAMED_MILK) == 9);
		assertTrue(inventory.getInventory(Ingredient.WHIPPED_CREAM) == 9);
	}
	
	@Test
	public void testbuildCappuccino() {

		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();

		// Since recipe of cappucino is espresso 2, steamed milk 1, and foamed milk 1 for ingredients
		// we check after building the drink, inventory has been updated correctly
		Drink cappucino = menu.getDrink(DrinkType.CAPPUCCINO);
		cappucino.build(inventory);
		assertTrue(inventory.getInventory(Ingredient.COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.CREAM) == 10);
		assertTrue(inventory.getInventory(Ingredient.SUGAR) == 10);
		assertTrue(inventory.getInventory(Ingredient.COCOA) == 10);
		assertTrue(inventory.getInventory(Ingredient.DECAF_COFFEE) == 10);
		assertTrue(inventory.getInventory(Ingredient.ESPRESSO) == 8);
		assertTrue(inventory.getInventory(Ingredient.FOAMED_MILK) == 9);
		assertTrue(inventory.getInventory(Ingredient.STEAMED_MILK) == 9);
		assertTrue(inventory.getInventory(Ingredient.WHIPPED_CREAM) == 10);
	}
	
	/* 
	 * 
	 * Price of drinks is calculated per price of individual ingredient
	 * in its recipe, we test if the cost calculated is correct
	 *  
	 */
	@Test
	public void testCaffeAmericanoPrice() {

		DrinkRecipe caffeAmericanoRecipe = new RecipeBuilderDirector()
				.buildCaffeAmericanoRecipe();

		String cost = String.format("%.2f", (Double) caffeAmericanoRecipe.getCost());
		assertEquals(cost, "3.30");
	}
	/* 
	 * 
	 * Price of drinks is calculated per price of individual ingredient
	 * in its recipe, we test if the cost calculated is correct
	 *  
	 */
	@Test
	public void testDecafCoffeePrice() {

		DrinkRecipe decafCoffeeRecipe = new RecipeBuilderDirector()
				.buildDecafCoffeeRecipe();

		String cost = String.format("%.2f", (Double) decafCoffeeRecipe.getCost());
		
		assertEquals(cost,"2.75");
	}
	/* 
	 * 
	 * Price of drinks is calculated per price of individual ingredient
	 * in its recipe, we test if the cost calculated is correct
	 *  
	 */
	@Test
	public void testCappuccinoPrice() {

		DrinkRecipe cappuccinoRecipe = new RecipeBuilderDirector()
				.buildCappuccinoRecipe();
		String cost = String.format("%.2f", (Double) cappuccinoRecipe.getCost());
		assertEquals(cost, "2.90");
	}
	/* 
	 * 
	 * Price of drinks is calculated per price of individual ingredient
	 * in its recipe, we test if the cost calculated is correct
	 *  
	 */
	@Test
	public void testCoffeePrice() {

		DrinkRecipe coffeeRecipe = new RecipeBuilderDirector()
				.buildCoffeeRecipe();
		assertEquals((Double) coffeeRecipe.getCost(), (Double) 2.75);
	}
	/* 
	 * 
	 * Price of drinks is calculated per price of individual ingredient
	 * in its recipe, we test if the cost calculated is correct
	 *  
	 */
	@Test
	public void testCaffeMochaPrice() {

		DrinkRecipe caffeMochaRecipe = new RecipeBuilderDirector()
				.buildCaffeMochaRecipe(); 

		String cost = String.format("%.2f", (Double) caffeMochaRecipe.getCost());
		assertEquals(cost, "3.35");
	}
	/* 
	 * 
	 * Price of drinks is calculated per price of individual ingredient
	 * in its recipe, we test if the cost calculated is correct
	 *  
	 */
	@Test
	public void testCaffeLattePrice() {

		DrinkRecipe caffeLatteRecipe = new RecipeBuilderDirector()
				.buildCaffeLatteRecipe();

		String cost = String.format("%.2f", (Double) caffeLatteRecipe.getCost());
		assertEquals(cost, "2.55");
	}

	@Test
	public void testDrinkBuildable() {
		
		Menu menu = new Menu(); 
		Inventory inventory = new Inventory();
		// We make inventory for all ingredients to 0 by subtracting 10.
		inventory.deductInventory(Ingredient.COCOA, 10);
		inventory.deductInventory(Ingredient.COFFEE, 10);
		inventory.deductInventory(Ingredient.CREAM, 10);
		inventory.deductInventory(Ingredient.DECAF_COFFEE, 10);
		inventory.deductInventory(Ingredient.ESPRESSO, 10);
		inventory.deductInventory(Ingredient.FOAMED_MILK, 10);
		inventory.deductInventory(Ingredient.STEAMED_MILK, 10);
		inventory.deductInventory(Ingredient.SUGAR, 10);
		
		// No drink should be buildable
		assertFalse(menu.getDrink(DrinkType.CAFFE_LATTE).isBuildable(inventory)); 
		assertFalse(menu.getDrink(DrinkType.COFFEE).isBuildable(inventory)); 
		assertFalse(menu.getDrink(DrinkType.DECAF_COFFEE).isBuildable(inventory)); 
		assertFalse(menu.getDrink(DrinkType.CAPPUCCINO).isBuildable(inventory)); 
		assertFalse(menu.getDrink(DrinkType.CAFFE_MOCHA).isBuildable(inventory));
		assertFalse(menu.getDrink(DrinkType.CAFFE_AMERICANO).isBuildable(inventory));
  
	}

	@Test(expected = OutOfStockException.class)
	public void testOutOfStock() throws OutOfStockException {
		// Initial count is 10 of all ingredients
		// We can only dispense cafe americano three times, and fourth time
		// it should throw an exception.
		
		BaristamaticMachine coffeeMachine = new BaristamaticMachine();
		coffeeMachine.dispense(DrinkType.CAFFE_AMERICANO);
		coffeeMachine.dispense(DrinkType.CAFFE_AMERICANO);
		coffeeMachine.dispense(DrinkType.CAFFE_AMERICANO);
		coffeeMachine.dispense(DrinkType.CAFFE_AMERICANO);
	}

	@Test
	public void testInventoryRestock() {
		Inventory inventory = new Inventory();

		inventory.deductInventory(Ingredient.COCOA, 10);
		inventory.deductInventory(Ingredient.COFFEE, 10);
		inventory.deductInventory(Ingredient.CREAM, 10);
		inventory.deductInventory(Ingredient.DECAF_COFFEE, 10);
		inventory.deductInventory(Ingredient.ESPRESSO, 10);
		inventory.deductInventory(Ingredient.FOAMED_MILK, 10);
		inventory.deductInventory(Ingredient.STEAMED_MILK, 10);
		inventory.deductInventory(Ingredient.SUGAR, 10);

		inventory.stockItems();
		// We first deduct all 10 items, then restock back to 10.
		
		assertEquals((Integer) inventory.getInventory(Ingredient.COCOA),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.COFFEE),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.CREAM),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.DECAF_COFFEE),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.ESPRESSO),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.FOAMED_MILK),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.STEAMED_MILK),
				(Integer) 10);
		assertEquals((Integer) inventory.getInventory(Ingredient.SUGAR),
				(Integer) 10);
	}

	@Test
	public void testInventoryUpdate() {
		Inventory inventory = new Inventory();

		inventory.deductInventory(Ingredient.COCOA, 10);
		inventory.deductInventory(Ingredient.COFFEE, 10);
		inventory.deductInventory(Ingredient.CREAM, 10);
		inventory.deductInventory(Ingredient.DECAF_COFFEE, 10);
		inventory.deductInventory(Ingredient.ESPRESSO, 10);
		inventory.deductInventory(Ingredient.FOAMED_MILK, 10);
		inventory.deductInventory(Ingredient.STEAMED_MILK, 10);
		inventory.deductInventory(Ingredient.SUGAR, 10);
		// We deduct all 10 and asserts that inventory count is 0 for all ingredients.
		assertEquals((Integer) inventory.getInventory(Ingredient.COCOA),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.COFFEE),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.CREAM),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.DECAF_COFFEE),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.ESPRESSO),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.FOAMED_MILK),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.STEAMED_MILK),
				(Integer) 0);
		assertEquals((Integer) inventory.getInventory(Ingredient.SUGAR),
				(Integer) 0);
	}

	@Test
	public void testGetCaffeAmericanoMenu() {
		// Get the drink from menu, and make sure it is the expected one.
		Menu menu = new Menu();
		DrinkType drinkType = DrinkType.CAFFE_AMERICANO;

		Drink caffeAmericano = menu.getDrink(drinkType);
		assertEquals(drinkType, caffeAmericano.getDrinkType());
	}

	@Test
	public void testGetCaffeLatteMenu() { 
		// Get the drink from menu, and make sure it is the expected one.
		Menu menu = new Menu();
		DrinkType drinkType = DrinkType.CAFFE_LATTE;

		Drink caffeLatte = menu.getDrink(drinkType);
		assertEquals(drinkType, caffeLatte.getDrinkType());
	}

	@Test
	public void testGetCaffeMochaMenu() { 
		// Get the drink from menu, and make sure it is the expected one.
		Menu menu = new Menu();
		DrinkType drinkType = DrinkType.CAFFE_MOCHA;

		Drink caffeMocha = menu.getDrink(drinkType);
		assertEquals(drinkType, caffeMocha.getDrinkType());
	}

	@Test
	public void testGetCappuccinoMenu() {
		// Get the drink from menu, and make sure it is the expected one.
		Menu menu = new Menu();
		DrinkType drinkType = DrinkType.CAPPUCCINO;

		Drink cappuccino = menu.getDrink(drinkType);
		assertEquals(drinkType, cappuccino.getDrinkType());
	}

	@Test
	public void testGetCoffeeMenu() {
		// Get the drink from menu, and make sure it is the expected one.
		Menu menu = new Menu();
		DrinkType drinkType = DrinkType.COFFEE;

		Drink coffee = menu.getDrink(drinkType);
		assertEquals(drinkType, coffee.getDrinkType());
	}

	@Test
	public void testGetDecafCoffeeMenu() {
		// Get the drink from menu, and make sure it is the expected one.
		Menu menu = new Menu();
		DrinkType drinkType = DrinkType.DECAF_COFFEE;

		Drink decafCoffee = menu.getDrink(drinkType);
		assertEquals(drinkType, decafCoffee.getDrinkType());
	}
}
