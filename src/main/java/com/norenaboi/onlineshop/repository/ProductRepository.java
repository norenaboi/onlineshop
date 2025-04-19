package com.norenaboi.onlineshop.repository;

import com.norenaboi.onlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByName(String name); // Find a product by its name
	List<Product> findByNameContaining(String keyword); // Search a product with a string
	List<Product> findByPriceBetween(double minPrice, double maxPrice); // List products within the price range
	List<Product> findByTypeOrderByPriceAsc(String type); // List products in certain categories
}