package com.coffeemachine.baristamatic;

import java.util.ArrayList;

/**
 * This class is the director for building a recipe. It has methods to create a
 * recipe with specific ingredients, for each drink type.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class RecipeBuilderDirector {

	public DrinkRecipe buildCoffeeRecipe() {
		DrinkRecipe coffeeRecipe = new DrinkRecipeBuilder().addIngredient(Ingredient.COFFEE, 3)
				.addIngredient(Ingredient.SUGAR).addIngredient(Ingredient.CREAM).buildRecipe();

		return coffeeRecipe;
	}

	public DrinkRecipe buildCaffeLatteRecipe() {
		DrinkRecipe caffeLatteRecipe = new DrinkRecipeBuilder().addIngredient(Ingredient.ESPRESSO, 2)
				.addIngredient(Ingredient.STEAMED_MILK).buildRecipe();

		return caffeLatteRecipe;
	}

	public DrinkRecipe buildCaffeMochaRecipe() {
		DrinkRecipe caffeMochaRecipe = new DrinkRecipeBuilder().addIngredient(Ingredient.ESPRESSO)
				.addIngredient(Ingredient.COCOA).addIngredient(Ingredient.STEAMED_MILK)
				.addIngredient(Ingredient.WHIPPED_CREAM).buildRecipe();

		return caffeMochaRecipe;
	}

	public DrinkRecipe buildCappuccinoRecipe() {
		DrinkRecipe cappuccinoRecipe = new DrinkRecipeBuilder().addIngredient(Ingredient.ESPRESSO, 2)
				.addIngredient(Ingredient.STEAMED_MILK).addIngredient(Ingredient.FOAMED_MILK).buildRecipe();

		return cappuccinoRecipe;
	}

	public DrinkRecipe buildDecafCoffeeRecipe() {
		DrinkRecipe decafCoffeeRecipe = new DrinkRecipeBuilder().addIngredient(Ingredient.DECAF_COFFEE, 3)
				.addIngredient(Ingredient.SUGAR).addIngredient(Ingredient.CREAM).buildRecipe();

		return decafCoffeeRecipe;
	}

	public DrinkRecipe buildCaffeAmericanoRecipe() {
		DrinkRecipe caffeAmericanoRecipe = new DrinkRecipeBuilder().addIngredient(Ingredient.ESPRESSO, 3).buildRecipe();

		return caffeAmericanoRecipe;
	}

	public DrinkRecipe buildCustomRecipe(ArrayList<CustomDrinkIngredient> customIngredients) {
		DrinkRecipeBuilder customRecipeBuilder = new DrinkRecipeBuilder();

		for (CustomDrinkIngredient ingredient : customIngredients)
			customRecipeBuilder.addIngredient(ingredient.getIngredient(), ingredient.getQuantity());

		return customRecipeBuilder.buildRecipe();

	}
}
