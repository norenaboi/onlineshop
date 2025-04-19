package com.norenaboi.onlineshop.controller;

import com.norenaboi.onlineshop.model.Product;
import com.norenaboi.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;
	
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public List<Product> getAllProducts(){
    	return productService.getAllProducts();
    }
    
    @GetMapping("/{id}") // GET
    public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
    
    @PostMapping // POST
    public Product createProduct(@RequestBody Product product) {
    	return productService.createProduct(product);
    }
    
    @PutMapping("/{id}") // PUT
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    	return productService.updateProduct(id, product);
    }
    
    @DeleteMapping("/{id}") // DELETE
    public void deleteProduct(@PathVariable Long id) {
    	productService.deleteProduct(id);
    }
    
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
    	return productService.getProductsByName(name);
    }
    
    @GetMapping("/price-range")
    public List<Product> getProductsInRange( @RequestParam double min, @RequestParam double max) {
        return productService.getProductsInPriceRange(min, max);
    }
    
    @GetMapping("/category/{type}")
    public List<Product> getProductsByCategory(@PathVariable String type) {
        return productService.getProductsByType(type);
    }
}