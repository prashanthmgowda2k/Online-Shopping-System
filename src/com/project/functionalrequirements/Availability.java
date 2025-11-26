package com.project.functionalrequirements;

public class Availability {
    private final boolean inStock;
    private final int quantity;

    public Availability(boolean inStock, int quantity) {
        this.inStock = inStock;
        this.quantity = quantity;
    }

    public boolean isInStock() { 
    	return inStock; 
    	}
    public int getQuantity() { 
    	return quantity; 
    	}
}

	
	


