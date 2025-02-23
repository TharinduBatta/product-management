package com.practicle.product_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    @NotEmpty(message = "Please provide a username" )
    private String name;

    @NotEmpty(message = "Please provide a description")
    private String description;

    @NotNull
    private Double price;

    @NotEmpty
    private String category;

    private String status;

}
