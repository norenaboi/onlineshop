package com.norenaboi.onlineshop.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	// Object properties
	private String id;
	private String name;
	private double price;
	private String type;
	private String description;
}