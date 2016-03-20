package com.coffeemachine.baristamatic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main entry point to the Baristamatic application.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class BaristamaticTest {

	public static void main(String[] args) throws InvalidInputException {

		// Baristamatic Machine object which is responsible for managing the
		// whole run.
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
			if (userInput.isEmpty() || userInput.length() > 1) {
				scanner.close();
				System.out.println("Input is empty or greater than 1.");
				throw new InvalidInputException("Invalid selection: " + userInput);
			}

			inputChar = userInput.charAt(0);

			// Break out of loop if input is q or Q
			if (Character.toLowerCase(inputChar) == 'q')
				break;

			if (Character.toLowerCase(inputChar) != 'r' && (inputChar < '1' || inputChar > '7')) {
				scanner.close();
				System.out.println("Invalid Selection of drink.");
				throw new InvalidInputException("Invalid selection: " + userInput);
			}

			// Re-stock and redisplay menu and inventory if input is r or R
			if (Character.toLowerCase(inputChar) == 'r') {
				coffeeMachine.restock();
				continue;
			}

			// Input is >1 and <7
			try {
				DrinkType drinkType = DrinkType.getDrinkType(Character.getNumericValue(inputChar));
				if (drinkType == (DrinkType.CUSTOM)) {
					ArrayList<CustomDrinkIngredient> customIngredientList = getCustomDrinkIngredient();
					coffeeMachine.dispense(DrinkType.CUSTOM, customIngredientList);
				} else
					coffeeMachine.dispense(drinkType);
			} catch (OutOfStockException e) {
				System.out.println(e.getMessage());
			}

		}
		scanner.close();
	}

	public static ArrayList<CustomDrinkIngredient> getCustomDrinkIngredient() {
		ArrayList<CustomDrinkIngredient> customDrinkList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String userInput;
		System.out.println("Please input ingredients per line with their quantity seperated by a comma. (q to quit)");
		while (true) {
			userInput = scanner.nextLine();

			// Reread input if its empty, greater than 1 character or invalid
			if (userInput.isEmpty()) {
				System.out.println("Input is empty");
				continue;
			}
			if (userInput.charAt(0) == 'q')
				break;
			String[] input = userInput.split(",");
			if (input.length != 2) {
				System.out.println("Input is invalid");
				continue;
			}

			if (Ingredient.contains(input[0].trim().toUpperCase()) == false) {
				System.out.println("Ingredient is invalid. " + input[0]);
				continue;
			}

			// Refactor with apache commons
			input[1] = input[1].trim();
			if (isNumeric(input[1]) == false) {
				System.out.println("Ingredient quantity is not numeric. " + input[1]);
				continue;

			}
			if (!(Integer.parseInt(input[1]) > 0 && Integer.parseInt(input[1]) < 10)) {
				System.out.println("Ingredient quantity is invalid. Should be less than 10.");
				continue;
			}

			customDrinkList.add(new CustomDrinkIngredient(Ingredient.valueOf(input[0].trim().toUpperCase()),
					Integer.parseInt(input[1])));

		}

		scanner.close();
		return customDrinkList;
	}

	// Refactor with apache commons
	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

}
