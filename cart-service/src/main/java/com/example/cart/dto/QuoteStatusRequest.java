package com.example.cart.dto;

import lombok.Data;

@Data
public class QuoteStatusRequest {

    private String quoteId;
    private String cartId;
    private String status;      // e.g. "IN_CART", "READY_FOR_PURCHASE"
}
