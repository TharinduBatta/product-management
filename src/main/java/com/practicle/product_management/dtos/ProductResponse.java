package com.practicle.product_management.dtos;

import lombok.Data;

@Data
public class ProductResponse {

    private String name;
    private String description;
    private Double price;
    private String category;
    private String status;
}
