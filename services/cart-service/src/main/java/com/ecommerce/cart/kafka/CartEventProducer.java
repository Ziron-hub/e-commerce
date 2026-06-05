package com.ecommerce.cart.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class CartEventProducer {

    @Channel("cart-events")
    Emitter<String> emitter;

    public void sendEvent(String message) {
        emitter.send(message);
    }
}
