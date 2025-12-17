package com.example.cart.event;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CartSavedEvent {
    private String cartId;
    private String accountId;
    private List<String> productIds;
    private LocalDateTime occurredAt;
}
