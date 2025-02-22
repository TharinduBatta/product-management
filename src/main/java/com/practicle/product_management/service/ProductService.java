package com.practicle.product_management.service;

import com.practicle.product_management.dtos.ProductRequest;
import com.practicle.product_management.dtos.ProductResponse;
import com.practicle.product_management.entity.Product;

import java.util.List;

 public interface  ProductService {

    Product  createProduct(final ProductRequest productRequest);

    Product updateProduct(final Long id, final ProductRequest productRequest);

    void deleteProduct(final Long id);

    List<ProductResponse> getProductsByCategory(final String category);

    List<ProductResponse> getPremiumProducts();

}
