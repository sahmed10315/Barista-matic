package com.coffeemachine.baristamatic;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
/**
 *  Possible drinks that can be made.
 */
public enum DrinkType {
	
	CAFFE_AMERICANO(1) {
		@Override
		public String toString() {
			return "Caffe Americano";
		}
	},
	CAFFE_LATTE(2) {
		@Override
		public String toString() {
			return "Caffe Latte";
		}
	},
	CAFFE_MOCHA(3) {
		@Override
		public String toString() {
			return "Caffe Mocha";
		}
	},
	CAPPUCCINO(4) {
		@Override
		public String toString() {
			return "Cappuccino";
		}
	},
	COFFEE(5) {
		@Override
		public String toString() {
			return "Coffee";
		}
	},
	DECAF_COFFEE(6) {
		@Override
		public String toString() {
			return "Decaf Coffee";
		}
	};

	// Assigns an integer with the drink
	private int ordinal;

	private DrinkType(int ordinal) {
		this.ordinal = ordinal;
	}
	
	/**
	 * This method gets the ordinal no for current drink.
	 * e.g Coffee = 5, Caffe Latte = 2
	 * @param void
	 * @return ordinal no.
	 */
	public int getOrdinal() {
		return ordinal;
	}
	
	// For mapping an integer to drink for easy loop up both ways.
	private static final Map<Integer, DrinkType> lookup = new HashMap<Integer, DrinkType>();

	static {
		for (DrinkType drinkType : EnumSet.allOf(DrinkType.class))
			lookup.put(drinkType.getOrdinal(), drinkType);
	}

	/**
	 * This static method gets the drink type of given ordinal integer.
	 * 
	 * @param ordinal
	 * @return DrinkType.
	 */
	public static DrinkType getDrinkType(int ordinal) {
		return lookup.get(ordinal);
	}
}
