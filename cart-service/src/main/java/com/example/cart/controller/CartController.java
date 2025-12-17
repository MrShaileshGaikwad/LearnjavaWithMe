package com.example.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart.domain.Cart;
import com.example.cart.dto.AddItemRequest;
import com.example.cart.dto.CartDto;
import com.example.cart.dto.CreateCartRequest;
import com.example.cart.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

    // Lombok will generate a constructor and inject this bean
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(@RequestBody CreateCartRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cartService.createCart(request));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable String cartId) {
        return ResponseEntity.ok(cartService.getCart(cartId));
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartDto> addItem(@PathVariable String cartId,
                                           @RequestBody AddItemRequest  request) {
        return ResponseEntity.ok(cartService.addItem(cartId, request));
    }

    @PutMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<CartDto> updateItem(@PathVariable String cartId,
                                              @PathVariable String itemId,
                                              @RequestBody UpdateItemRequest request) {
        return ResponseEntity.ok(cartService.updateItem(cartId, itemId, request));
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable String cartId,
                                           @PathVariable String itemId) {
        cartService.removeItem(cartId, itemId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{cartId}/save")
    public ResponseEntity<CartDto> saveCart(@PathVariable String cartId) {
        return ResponseEntity.ok(CartService.saveCart(cartId));
    }

    @PostMapping("/{cartId}/activate")
    public ResponseEntity<CartDto> activateCart(@PathVariable String cartId) {
        return ResponseEntity.ok(cartService.activateCart(cartId));
    }

    @PostMapping("/{cartId}/expire")
    public ResponseEntity<Void> expireCart(@PathVariable String cartId) {
        cartService.expireCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
