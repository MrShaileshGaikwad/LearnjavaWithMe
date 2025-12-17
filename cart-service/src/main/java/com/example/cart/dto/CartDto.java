package com.example.cart.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private String id;
    private String accountId;
    private String status;
    private String additionalNotes;
    private List<CartDto> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
