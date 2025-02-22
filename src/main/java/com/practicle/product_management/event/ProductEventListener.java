package com.practicle.product_management.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEventListener {

    @EventListener
    public void handleProductCreatedEvent(ProductCreatedEvent event) {
        log.info("Received event for product creation: {}", event.getProduct().getName());

    }
}
