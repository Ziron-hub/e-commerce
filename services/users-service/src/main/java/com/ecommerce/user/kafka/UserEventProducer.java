package com.ecommerce.user.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class UserEventProducer {

    @Channel("users-events")
    Emitter<String> emitter;

    public void sendEvent(String message) {
        emitter.send(message);
    }
}
