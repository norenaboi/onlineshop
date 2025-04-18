package com.norenaboi.onlineshop.service;

import com.norenaboi.onlineshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.ArrayList;

@Service
public class ProductService {
	private final HashMap<String, Product> products = new HashMap<>();
	
	public ProductService() {
		// Create new products
		products.put("1", new Product("1", "Sofa", 249.99, "furniture", "A long, comfortable seat with a back and arms."));
		products.put("2", new Product("2", "Yoga Mat ", 29.99, "furniture", "Non-slip, 6mm thickness."));
		products.put("3", new Product("3", "Coffee Table ", 99.99, "furniture", "Small round table, made of wood."));
		products.put("4", new Product("4", "Smartphone", 799.99, "electronic", "Latest model with 128GB storage."));
		products.put("5", new Product("5", "Wireless Earbuds", 149.99, "electronic", "Noise cancelling, 20hr battery"));
		products.put("6", new Product("6", "Laptop", 1299.99, "electronic", "15.6\" Full HD, 1TB storage with NTX 4070."));
		products.put("7", new Product("7", "Mug", 19.99, "home_kitchen", "A cup with a cat picture on it."));
		products.put("8", new Product("8", "Blender", 59.99, "home_kitchen", "High-speed 1200W."));
		products.put("9", new Product("9", "Vacuum", 169.99, "home_kitchen", "Wireless vacuum, 2 hour battery."));
		products.put("10", new Product("10", "Sunglasses", 29.99, "fashion", "UV protection, polarized lenses."));
		products.put("11", new Product("11", "Sneakers", 89.99, "fashion", "Lightweight, breathable, ."));
		products.put("12", new Product("12", "Watch", 89.99, "fashion", "Stainless steel, analog display."));
	}
	
	public ArrayList<Product> getAllProducts(){
		return new ArrayList<>(products.values());
	}
	
	public Product getProductById(String id) {
		return products.get(id);
	}
	
	public Product createProduct(Product product) {
		products.put(product.getId(), product);
		return product;
	}
	
	public Product updateProduct(String id, Product product) {
		if(products.containsKey(id)) {
			products.put(id, product);
			return product;
		}
		return null;
	}
	
	public boolean deleteProduct(String id) {
		return products.remove(id) != null;
	}
}