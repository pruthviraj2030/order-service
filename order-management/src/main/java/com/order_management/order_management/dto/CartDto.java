package com.order_management.order_management.dto;

import com.order_management.order_management.model.Cart;

public class CartDto {
    public Long id;
    public Long productId;
    public Long quantity;
    public Long userId;

    public CartDto(Cart cart) {
        this.id=cart.getId();
        this.productId = cart.getProductId();
        this.quantity = cart.getQuantity();
        this.userId = cart.getUserId();
    }
}
