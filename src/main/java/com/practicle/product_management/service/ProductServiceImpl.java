package com.practicle.product_management.service;

import com.practicle.product_management.dtos.ProductRequest;
import com.practicle.product_management.dtos.ProductResponse;
import com.practicle.product_management.entity.Product;
import com.practicle.product_management.event.ProductCreatedEvent;
import com.practicle.product_management.exception.ResourceNotFoundException;
import com.practicle.product_management.repository.ProductRepository;
import com.practicle.product_management.transformer.ProductTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * In this class maintain based on the product related implementations
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;


    /**
     * Created new product
     * @param productRequest
     * @return Product
     */
    @Override
    public Product createProduct(ProductRequest productRequest) {
        log.info("Creating product: {}", productRequest.getName());
        Product savedProduct = productRepository.save(ProductTransformer.toProduct(productRequest));
        eventPublisher.publishEvent(new ProductCreatedEvent(savedProduct));
        return savedProduct;
    }

    /**
     * Update new praduct
     * @param id
     * @param productRequest
     * @return Product
     */
    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) {
        log.info("Updating product with ID: {}", id);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        return productRepository.save(existingProduct);
    }

    /**
     * Delete the product
     * @param id
     */
    @Override
    public void deleteProduct(Long id) {
        log.info("Soft deleting product with ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setStatus("D");
        productRepository.save(product);
    }

    /**
     * Retrieve the product based on the category
     * @param category
     * @return List<ProductResponse>
     */
    @Override
    public List<ProductResponse> getProductsByCategory(String category) {

        log.info("Fetching products by category: {}", category);
        List<Product> productList = productRepository.findByCategory(category);
        return ProductTransformer.toProductResponseList(productList);
    }

    /**
     * Retrieve all premium products (price >= $500)
     * @return List<ProductResponse>
     */
    @Override
    public List<ProductResponse> getPremiumProducts() {
        log.info("Fetching premium products");
        List<Product> productList = productRepository.findByPriceGreaterThanEqual(500.0);
        return ProductTransformer.toProductResponseList(productList);
    }
}
