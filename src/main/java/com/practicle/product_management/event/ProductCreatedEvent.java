package com.practicle.product_management.event;

import com.practicle.product_management.entity.Product;
import org.springframework.context.ApplicationEvent;

/**
 * This class is use for the create event based on the product
 */
public class ProductCreatedEvent extends ApplicationEvent {

    private final Product product;

    public ProductCreatedEvent(Product product) {
        super(product);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
