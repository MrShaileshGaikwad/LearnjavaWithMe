package com.example.cart.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateItemRequest {
    private int quantity;
    private BigDecimal unitPrice;
}
