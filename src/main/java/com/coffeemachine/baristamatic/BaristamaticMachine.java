package com.coffeemachine.baristamatic;

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * A class to simulate a coffee dispenser machine. This is the outside interface
 * for clients to interact with the machine.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class BaristamaticMachine {

	private Menu menu;
	private Inventory inventory;

	/**
	 * Default Constructor.
	 */
	public BaristamaticMachine() {
		menu = new Menu();
		inventory = new Inventory();
	}

	/**
	 * This method is used to display inventory.
	 * 
	 * @param void
	 * @return void.
	 */
	public void displayInventory() {
		inventory.displayInventory();
	}

	/**
	 * This method is used to display menu of available drinks, with their price
	 * and availability.
	 * 
	 * @param void
	 * @return void.
	 */
	void displayMenu() {

		System.out.println("Menu: ");

		for (Entry<Integer, Drink> menuItem : menu) {
			Drink drink = menuItem.getValue();
			boolean buildable = drink.isBuildable(inventory);

			System.out.println(menuItem.getKey() + "," + drink.getDrinkType() + ","
					+ String.format("$%.2f", drink.getCost()) + "," + buildable);
		}
		System.out.println("7," + DrinkType.CUSTOM + ", Cost varies on ingredients." );
		System.out.println();
	}

	/**
	 * This method is used to dispense the specified drink, and updates the
	 * inventory. If drink is not buildable from inventory items, then throw an
	 * exception.
	 * 
	 * @param drinkType
	 * @return void.
	 */
	public void dispense(DrinkType drinkType) throws OutOfStockException {

		Drink drink = menu.getDrink(drinkType);

		if (!drink.isBuildable(inventory))
			throw new OutOfStockException("Out of Stock: " + drink);

		System.out.println("Dispensing: " + drink.getDrinkType());
		drink.build(inventory);
	}

	/**
	 * This method re-stocks the inventory to 10 items per ingredient.
	 * 
	 * @param void
	 * @return void.
	 */
	public void restock() {
		inventory.stockItems();
	}

	public void dispense(DrinkType custom, ArrayList<CustomDrinkIngredient> customIngredients)
			throws OutOfStockException {

		Drink drink = menu.makeCustomDrink(customIngredients);

		if (!drink.isBuildable(inventory))
			throw new OutOfStockException("Out of Stock: " + drink);

		System.out.println("Dispensing: " + drink.getDrinkType());
		drink.build(inventory);
	}
}
