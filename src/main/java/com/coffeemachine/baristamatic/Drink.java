package com.coffeemachine.baristamatic;

import java.util.Map.Entry;

/**
 * This class is an abstraction for a drink.
 * All drinks contain different recipe, which defines its costs.
 * All drinks are also instantiated with a Drink Type.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class Drink {

	private DrinkRecipe drinkRecipe;
	private DrinkType drinkType;

	/**
	 * Constructor takes a drink type and a recipe to create a drink object.
	 */
	public Drink(DrinkType drinkType, DrinkRecipe recipe) {
		this.setDrinkType(drinkType);
		this.setDrinkRecipe(recipe);
	} 
	
	/**
	 * Prints the drink name from the drink type.
	 * @return Drink Name
	 */
	public String toString() {
		return getDrinkType().toString();
	}

	/**
	 * This method builds the drink from the inventory.
	 * It iterates over the recipe ingredients, and subtracts those items from the inventory.
	 * 
	 * @param Inventory
	 * @return void.
	 */
	public void build(Inventory inventory) {

		for (Entry<Ingredient, Integer> recipeItem : this.getDrinkRecipe()) {
			inventory.deductInventory(recipeItem.getKey(), recipeItem.getValue());
		}
	}

	/**
	 * This method sees if the current drink is buildable from the inventory provided.
	 * It iterates over the recipe ingredients, and checks if all ingredient in required quantity
	 * are present in the inventory.
	 * 
	 * @param Inventory
	 * @return boolean.
	 */
	public boolean isBuildable(Inventory inventory) {

		for (Entry<Ingredient, Integer> recipeItem : getDrinkRecipe())
			if (!(inventory.inStock(recipeItem.getKey(), recipeItem.getValue())))
				return false;
		return true;
	}

	/**
	 * Getter method for cost of the current drink
	 * 
	 * @param void
	 * @return Double.
	 */
	public Double getCost() { 
		return getDrinkRecipe().getCost();
	}
	/**
	 * 
	 * Private Setter method for cost drink type
	 * 
	 * @param DrinkType
	 * @return void.
	 */
	private void setDrinkType(DrinkType name) {
		this.drinkType = name;
	}
	
	/**
	 * Getter method for drink type
	 * 
	 * @param void
	 * @return DrinkType.
	 */
	public DrinkType getDrinkType() {
		return drinkType;
	}
	
	/**
	 * Private setter method for drink recipe
	 * 
	 * @param DrinkRecipe
	 * @return void.
	 */
	private void setDrinkRecipe(DrinkRecipe drinkRecipe) {
		this.drinkRecipe = drinkRecipe;
	}
	
	/**
	 * Getter method for drink recipe
	 * 
	 * @param void
	 * @return DrinkRecipe.
	 */
	public DrinkRecipe getDrinkRecipe() {
		return drinkRecipe;
	}
}