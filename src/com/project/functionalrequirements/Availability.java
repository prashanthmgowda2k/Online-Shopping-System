package com.project.functionalrequirements;

public class Availability {
	
	public static final Availability IN_STOCK = null;
	private boolean inStock;
	private int quantity;
	Product id;
	
	public Availability(Product id, boolean inStock, int quantity) {
		super();
		this.inStock = inStock;
		this.quantity = quantity;
		
	}
	
	

}
