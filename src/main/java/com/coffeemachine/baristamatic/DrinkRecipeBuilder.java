package com.coffeemachine.baristamatic;

/**
 * This class follows is builder pattern for recipe.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class DrinkRecipeBuilder {

	private DrinkRecipe drinkRecipe = new DrinkRecipe();
	
	/**
	 * This method adds an ingredient to the recipe.
	 * It also adds the ingredient cost to the overall cost.
	 * 
	 * @param Ingredient 
	 * @return DrinkRecipeBuilder
	 */
	DrinkRecipeBuilder addIngredient(Ingredient ingredient){
		drinkRecipe.addIngredient(ingredient);
		drinkRecipe.addToPrice(ingredient.getCost());
		return this;
	}
	
	/**
	 * This method adds an ingredient to the recipe in the specified quantity.
	 * It also adds the ingredient cost to the overall cost..
	 * 
	 * @param Ingredient , Quantity
	 * @return DrinkRecipeBuilder
	 */
	DrinkRecipeBuilder addIngredient(Ingredient ingredient, int quantity){
		
		for(int i = 0; i < quantity; i++)
		{
			drinkRecipe.addIngredient(ingredient);
			drinkRecipe.addToPrice(ingredient.getCost());
		}
		return this;
	}
	
	/**
	 * This method gets the final recipe product after its creation.
	 * 
	 * @param void 
	 * @return DrinkRecipe
	 */
	DrinkRecipe buildRecipe(){
		return drinkRecipe;
	}
}
