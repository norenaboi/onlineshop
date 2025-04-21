package com.norenaboi.onlineshop.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
public class ProductDTO {
	private Long id;
	
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 20, message = "Name must be between 2-100 characters")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Type is required")
    private String type;

    @Size(max = 100, message = "Description cannot exceed 500 characters")
    private String description;
}
