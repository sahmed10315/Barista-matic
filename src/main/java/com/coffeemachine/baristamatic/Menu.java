package com.coffeemachine.baristamatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * This class encapsulates menu and provides an interface to access it. We make
 * it iterable, so that the client can iterate over individual menu items.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class Menu implements Iterable<Entry<Integer, Drink>> {

	HashMap<Integer, Drink> menu;

	/**
	 * Default Constructor.
	 */
	public Menu() {
		menu = new HashMap<Integer, Drink>();
		this.buildMenu();
	}

	/**
	 * This method is used to build the menu.
	 * 
	 * @param void
	 * @return void.
	 */
	public void buildMenu() {
		RecipeBuilderDirector recipeBuildDirector = new RecipeBuilderDirector();
		// Creates the drink first by making its recipe which fetch its
		// ingredients and calculates the costs, and add it in the map
		// as an integer to drink mapping.
		menu.put(DrinkType.CAFFE_AMERICANO.getOrdinal(),
				new Drink(DrinkType.CAFFE_AMERICANO, recipeBuildDirector.buildCaffeAmericanoRecipe()));
		menu.put(DrinkType.CAFFE_LATTE.getOrdinal(),
				new Drink(DrinkType.CAFFE_LATTE, recipeBuildDirector.buildCaffeLatteRecipe()));
		menu.put(DrinkType.CAFFE_MOCHA.getOrdinal(),
				new Drink(DrinkType.CAFFE_MOCHA, recipeBuildDirector.buildCaffeMochaRecipe()));
		menu.put(DrinkType.CAPPUCCINO.getOrdinal(),
				new Drink(DrinkType.CAPPUCCINO, recipeBuildDirector.buildCappuccinoRecipe()));
		menu.put(DrinkType.COFFEE.getOrdinal(), new Drink(DrinkType.COFFEE, recipeBuildDirector.buildCoffeeRecipe()));
		menu.put(DrinkType.DECAF_COFFEE.getOrdinal(),
				new Drink(DrinkType.DECAF_COFFEE, recipeBuildDirector.buildDecafCoffeeRecipe()));
	}

	public Drink makeCustomDrink(ArrayList<CustomDrinkIngredient> customIngredients) {
		RecipeBuilderDirector recipeBuildDirector = new RecipeBuilderDirector();
		DrinkRecipe customRecipe = recipeBuildDirector.buildCustomRecipe(customIngredients);
		Drink drink = new Drink(DrinkType.CUSTOM, customRecipe);
		return drink;
	}

	/**
	 * 
	 * This method is used to make the menu iterable for outside objects.
	 * 
	 * @param void
	 * @return void.
	 */
	@Override
	public Iterator<Entry<Integer, Drink>> iterator() {
		return menu.entrySet().iterator();
	}

	/**
	 * This method gets the Drink from the menu.
	 * 
	 * @param DrinkType
	 * @return Drink.
	 */
	public Drink getDrink(DrinkType drinkType) {
		return menu.get(drinkType.getOrdinal());
	}

}
