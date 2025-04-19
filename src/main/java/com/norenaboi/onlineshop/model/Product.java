package com.norenaboi.onlineshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product { // Object properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private String type;
	private String description;
	
	public Product() {}
	
    public Product(Long id, String name, double price, String type, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
    }  
    
	// Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}