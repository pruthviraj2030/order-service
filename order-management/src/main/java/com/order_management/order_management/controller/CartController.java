package com.order_management.order_management.controller;

import com.order_management.order_management.dto.CartDto;
import com.order_management.order_management.dto.CartRequest;
import com.order_management.order_management.service.contract.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("v1/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping()
    public ResponseEntity<CartDto> addToCart(@RequestBody CartRequest cartRequest) {
        try {
            return new ResponseEntity<>(cartService.addToCart(cartRequest), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("user/{userId}/getAllItems")
    public ResponseEntity<List<CartDto>> getAllCartItems(@PathVariable Long userId){
        try {
            return new ResponseEntity<>(cartService.getAllCartItems(userId), HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{cartId}/user/{userId}/removeItemFromCart")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartId, Long userId){
        try {
            cartService.removeItemFromCart(userId, cartId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }



}
