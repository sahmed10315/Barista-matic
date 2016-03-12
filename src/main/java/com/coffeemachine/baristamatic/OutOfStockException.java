package com.coffeemachine.baristamatic;

/**
 * Out of stock exception class for handling out of stock drinks.
 * 
 * @author Saad Ahmed
 * @version 1.0
 * @since 2016-01-19
 */
public class OutOfStockException extends Exception { 
	
	private static final long serialVersionUID = 1L;
 
    public OutOfStockException() {}
 
    public OutOfStockException(String message)
    {
       super(message);
    }
    
    public OutOfStockException (Throwable cause) {
        super (cause);
    }

    public OutOfStockException (String message, Throwable cause) {
        super (message, cause);
    }
}
