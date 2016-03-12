package com.coffeemachine.baristamatic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * This class encapsulates a drink recipe and provides an interface to access it.
 * This class is also iterable so outside objects can iterate over each recipe ingredient.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class DrinkRecipe implements Iterable<Entry<Ingredient, Integer>> {

	private HashMap<Ingredient, Integer> recipe = new HashMap<Ingredient, Integer>();
	private double totalCost;
	
	/**
	 * This method adds an ingredient to the recipe.
	 * If it already exists, update the quantity.
	 * 
	 * @param Ingredient 
	 * @return void
	 */
	public void addIngredient(Ingredient ingredient) {
		Integer quantity = recipe.get(ingredient);
		if(quantity == null)
			recipe.put(ingredient, 1);
		else
			recipe.put(ingredient, ++quantity);
	}
	
	/**
	 * This method adds an ingredient price to the total price.
	 * 
	 * @param ingredient cost 
	 * @return void
	 */
	public void addToPrice(double cost) {
		this.totalCost += cost;
	}
	
	@Override
	public Iterator<Entry<Ingredient, Integer>> iterator() {
		return recipe.entrySet().iterator();
	}
	
	/**
	 * This method gets the total cost of the drink.
	 * 
	 * @param void
	 * @return total cost
	 */
	public double getCost() {
		return totalCost;
	}
}
