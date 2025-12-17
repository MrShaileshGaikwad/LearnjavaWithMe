package com.example.cart.service;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartItem;
import com.example.cart.event.CartSavedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartEventPublisher {

    private static final String TOPIC = "cart-saved";

    private final KafkaTemplate<String, CartSavedEvent> kafkaTemplate;

    public void publishCartSaved(Cart cart) {
        CartSavedEvent event = CartSavedEvent.builder()
                .cartId(cart.getId())
                .accountId(cart.getAccountId())
                .productIds(
                        cart.getItems().stream()
                                .map(CartItem::getProductId)
                                .collect(Collectors.toList())
                )
                .occurredAt(LocalDateTime.now())
                .build();

        kafkaTemplate.send(TOPIC, cart.getId(), event);
    }
}
