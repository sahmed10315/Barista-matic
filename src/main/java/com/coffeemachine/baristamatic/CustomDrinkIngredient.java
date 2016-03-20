package com.coffeemachine.baristamatic;

public class CustomDrinkIngredient {

	private Ingredient ingredient;
	private int quantity;

	public CustomDrinkIngredient(Ingredient ingredient, int quantity) {
		this.setIngredient(ingredient);
		this.setQuantity(quantity);
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
