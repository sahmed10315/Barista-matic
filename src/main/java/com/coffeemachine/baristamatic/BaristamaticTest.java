package com.coffeemachine.baristamatic;

import java.util.Scanner;

/**
 * This is the main entry point to the Baristamatic application.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class BaristamaticTest {

	public static void main(String[] args) { 
		
		// Baristamatic Machine object which is responsible for managing the whole run.
		BaristamaticMachine coffeeMachine = new BaristamaticMachine();

		Scanner scanner = new Scanner(System.in);
		String userInput;
		Character inputChar = 0;  
		
		while (true) {
			// Display Inventory and menu
			coffeeMachine.displayInventory();
			coffeeMachine.displayMenu();
			
			userInput = scanner.nextLine();
			
			// Reread input if its empty, greater than 1 character or invalid
			if (userInput.isEmpty())
				continue;

			if (userInput.length() > 1) {
				System.out.println("Invalid selection: " + userInput);
				continue;
			}

			inputChar = userInput.charAt(0);
			
			// Break out of loop if input is q or Q
			if (Character.toLowerCase(inputChar) == 'q')
				break;

			if (Character.toLowerCase(inputChar) != 'r'
					&& (inputChar < '1' || inputChar > '6')) {
				System.out.println("Invalid selection: " + userInput);
				continue;
			}
			
			//Re-stock and redisplay menu and inventory if input is r or R
			if (Character.toLowerCase(inputChar) == 'r') {
				coffeeMachine.restock();
				continue;
			}
			
			// Input is >1 and <6
			try { 
				DrinkType drinkType = DrinkType.getDrinkType(Character.getNumericValue(inputChar)); 
				coffeeMachine.dispense(drinkType);
			} catch (OutOfStockException e) {
				System.out.println(e.getMessage()); 
			} 
		}
		scanner.close();
	} 
}
