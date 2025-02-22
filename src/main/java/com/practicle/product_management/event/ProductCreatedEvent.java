package com.practicle.product_management.event;

import com.practicle.product_management.entity.Product;
import org.springframework.context.ApplicationEvent;

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
