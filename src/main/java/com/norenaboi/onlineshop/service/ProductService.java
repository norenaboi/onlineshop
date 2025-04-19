package com.norenaboi.onlineshop.service;
import org.springframework.stereotype.Service;

import com.norenaboi.onlineshop.model.Product;
import com.norenaboi.onlineshop.repository.ProductRepository;

import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void init() {
		if (productRepository.count() == 0) {
			List<Product> initialProducts = List.of( // Initialize products 
					new Product(null, "Sofa", 249.99, "furniture", "A long, comfortable seat with a back and arms."),
					new Product(null, "Yoga Mat", 29.99, "furniture", "Non-slip, 6mm thickness."),
					new Product(null, "Coffee Table ", 99.99, "furniture", "Small round table, made of wood."),
					new Product(null, "Smartphone", 799.99, "electronic", "Latest model with 128GB storage."),
					new Product(null, "Wireless Earbuds", 149.99, "electronic", "Noise cancelling, 20hr battery"),
					new Product(null, "Laptop", 1299.99, "electronic", "15.6\" Full HD, 1TB storage with NTX 4070."),
					new Product(null, "Mug", 19.99, "home_kitchen", "A cup with a cat picture on it."),
					new Product(null, "Blender", 59.99, "home_kitchen", "High-speed 1200W."),
					new Product(null, "Vacuum", 169.99, "home_kitchen", "Wireless vacuum, 2 hour battery."),
					new Product(null, "Sunglasses", 29.99, "fashion", "UV protection, polarized lenses."),
					new Product(null, "Sneakers", 89.99, "fashion", "Lightweight, breathable."),
					new Product(null, "Watch", 89.99, "fashion", "Stainless steel, analog display.")
			); productRepository.saveAll(initialProducts);
		}
	}
	
	public Product getProductById(Long id) { // GET
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public Product createProduct(Product product) { // POST
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, Product product) { // PUT
		Product existingProduct = getProductById(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setType(product.getType());
		existingProduct.setDescription(product.getDescription());
		return productRepository.save(existingProduct);
	}
	
	public void deleteProduct(Long id) { // DELETE
		productRepository.deleteById(id);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}
	
	public List<Product> getProductsInPriceRange(double min, double max) {
		return productRepository.findByPriceBetween(min, max);
	}
	
	public List<Product> getProductsByKeyword(String keyword) {
		return productRepository.findByNameContaining(keyword);
	}
		
	public List<Product> getProductsByType(String type) {
		return productRepository.findByTypeOrderByPriceAsc(type);
	}
}