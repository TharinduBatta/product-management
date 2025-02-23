package com.practicle.product_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private Double price;

    @NotEmpty
    private String category;

    private String status;

}
