package com.example.cart.mapper;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartItem;
import com.example.cart.dto.CartDto;
import com.example.cart.dto.CartItemDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDto toDto(Cart cart) {
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setAccountId(cart.getAccountId());
        dto.setStatus(cart.getStatus().name());
        dto.setCreatedAt(cart.getCreatedAt());
        dto.setUpdatedAt(cart.getUpdatedAt());

        if (cart.getItems() != null) {
            dto.setItems(
                cart.getItems().stream()
                    .map(this::toItemDto)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }

    private CartItemDto toItemDto(CartItem item) {
        CartItemDto dto = new CartItemDto();
        dto.setProductId(item.getProductId());
        dto.setQuantity(item.getQuantity());
        dto.setUnitPrice(item.getUnitPrice());
        return dto;
    }
}
