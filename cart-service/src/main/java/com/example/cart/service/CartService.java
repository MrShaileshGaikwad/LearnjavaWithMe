package com.example.cart.service;

import com.example.cart.dto.AddItemRequest;
import com.example.cart.dto.CartDto;
import com.example.cart.dto.CreateCartRequest;
import com.example.cart.dto.UpdateItemRequest;

public interface CartService {
    CartDto createCart(CreateCartRequest request);
    CartDto getCart(String cartId);
    CartDto addItem(String cartId, AddItemRequest request);
    CartDto updateItem(String cartId, String itemId, UpdateItemRequest request);
    void removeItem(String cartId, String itemId);
    CartDto saveCart(String cartId);
    CartDto activateCart(String cartId);
    void expireCart(String cartId);
}
