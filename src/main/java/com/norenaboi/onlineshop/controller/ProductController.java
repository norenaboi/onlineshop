package com.norenaboi.onlineshop.controller;

import com.norenaboi.onlineshop.dto.ProductDTO;
import com.norenaboi.onlineshop.model.Product;
import com.norenaboi.onlineshop.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/create")
    public String requestCreateProduct(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "create";
    }
    
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) { model.addAttribute("productDTO", productDTO); return "create"; }
    	Product product = convertToEntity(productDTO);
        productService.createProduct(product);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable  Long id, Model model) {
    	Product product = productService.getProductById(id);
        model.addAttribute("productDTO", convertToDTO(product));
        return "edit";
    }
    
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) { model.addAttribute("productDTO", productDTO); return "edit"; }
        productDTO.setId(id);
    	Product product = convertToEntity(productDTO);
        productService.editProduct(productDTO.getId(), product);
        return "redirect:/"; // Redirect to home page after edit
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
    
    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setType(product.getType());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
    
    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setType(productDTO.getType());
        product.setDescription(productDTO.getDescription());
        return product;
    }
}
