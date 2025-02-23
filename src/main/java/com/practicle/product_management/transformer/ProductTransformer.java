package com.practicle.product_management.transformer;

import com.practicle.product_management.dtos.ProductRequest;
import com.practicle.product_management.dtos.ProductResponse;
import com.practicle.product_management.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class maintain the product based transformers
 */
public class ProductTransformer {

    /**
     * Convert product request to product
     * @param productRequest
     * @return Product
     */
    public static Product toProduct(final ProductRequest productRequest) {
        final Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setDescription(productRequest.getDescription());
        product.setStatus("A");

        return product;
    }

    /**
     * Convert to list of product to the product response
     * @param productList
     * @return List<ProductResponse>
     */
    public static List<ProductResponse> toProductResponseList (final List<Product> productList){
        return productList.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setPrice(product.getPrice());
            response.setCategory(product.getCategory());
            response.setStatus(product.getStatus());
            return response;
        }).collect(Collectors.toList());
    }
}
