package com.example.cart.dto;

import lombok.Data;
import java.util.List;

@Data
public class CreateCartRequest {
    private String accountId;
    private List<CartDto> items;
}
