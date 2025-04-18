package com.norenaboi.onlineshop.controller;

import com.norenaboi.onlineshop.model.Product;
import com.norenaboi.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;
	
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ArrayList<Product> getAllProducts(){
    	return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getProductById(String id) {
		return productService.getProductById(id);
	}
    
    @PostMapping
    public Product createProduct(Product product) {
    	return productService.createProduct(product);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(String id, Product product) {
    	return productService.updateProduct(id, product);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteProduct(String id) {
    	return productService.deleteProduct(id);
    }
}