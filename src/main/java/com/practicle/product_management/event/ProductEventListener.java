package com.practicle.product_management.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Listener component that handles events related to product operations.
 */
@Component
@Slf4j
public class ProductEventListener {

    /**
     * This method is triggered when a {@link ProductCreatedEvent} is published
     * within the application context. It logs the name of the created product
     * for auditing and tracking purposes.
     * @param event
     */
    @EventListener
    public void handleProductCreatedEvent(ProductCreatedEvent event) {
        log.info("Received event for product creation: {}", event.getProduct().getName());

    }
}
