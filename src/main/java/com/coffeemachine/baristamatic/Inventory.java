package com.coffeemachine.baristamatic;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * This class encapsulates inventory and provides an interface to access it.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class Inventory {

	private TreeMap<Ingredient, Integer> inventory;

	/**
	 * Default Constructor.
	 */
	public Inventory() {
		inventory = new TreeMap<Ingredient, Integer>();
		stockItems();
	}

	/**
	 * This method is used to stock inventory with 10 items.
	 * 
	 * @param void
	 * @return void.
	 */
	public void stockItems() {
		inventory.put(Ingredient.COFFEE, 10);
		inventory.put(Ingredient.DECAF_COFFEE, 10);
		inventory.put(Ingredient.SUGAR, 10);
		inventory.put(Ingredient.CREAM, 10);
		inventory.put(Ingredient.STEAMED_MILK, 10);
		inventory.put(Ingredient.FOAMED_MILK, 10);
		inventory.put(Ingredient.ESPRESSO, 10);
		inventory.put(Ingredient.COCOA, 10);
		inventory.put(Ingredient.WHIPPED_CREAM, 10);
	}

	/**
	 * This method is used to display inventory with their remaining items.
	 * 
	 * @param void
	 * @return void.
	 */
	void displayInventory() {
		System.out.println("Inventory: ");
		for (Entry<Ingredient, Integer> item : inventory.entrySet())
			System.out.println(item.getKey() + "," + item.getValue()); 
	}

	/**
	 * This method is used to check if inventory contains the item in specified
	 * quantity.
	 * 
	 * @param Ingredient
	 *            , Quantity
	 * @return true/false boolean.
	 */
	boolean inStock(Ingredient ingredient, Integer desiredQuantity) {
		int remainingQuantity = inventory.get(ingredient);
		if (remainingQuantity >= desiredQuantity)
			return true;

		return false;
	}

	/**
	 * This method is used to update(deduct) inventory item in specified
	 * quantity.
	 * 
	 * @param Ingredient
	 *            , Quantity
	 * @return true/false boolean.
	 */
	public void deductInventory(Ingredient ingredient, Integer quantity) {
		Integer newQuantity = inventory.get(ingredient);
		newQuantity -= quantity;
		inventory.put(ingredient, newQuantity);
	} 
	
	/**
	 * This method is used to  get count of an ingredient in inventory. 
	 * 
	 * @param Ingredient 
	 * @return Quantity
	 */
	public Integer getInventory(Ingredient ingredient) {
		Integer quantity = inventory.get(ingredient);
		return quantity;
	} 
	
}
