package com.example.cart.dto;

import lombok.Data;

@Data
public class AddItemRequest {
    private String cartId;
    private String productId;
    private int quantity;
    private double unitPrice;
}

