package com.norenaboi.onlineshop.model;

public class Product {
	// Object properties
	private String id;
	private String name;
	private double price;
	private String type;
	private String description;
	
	public Product() {}
	
	public Product(String id, String name, double price, String type, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.description = description;
	}
	
	// Getters and setters
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}