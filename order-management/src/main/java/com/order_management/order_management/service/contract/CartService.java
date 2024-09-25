package com.order_management.order_management.service.contract;

import com.order_management.order_management.dto.CartDto;
import com.order_management.order_management.dto.CartRequest;

import java.util.List;

public interface CartService {
    CartDto addToCart(CartRequest cartRequest);

    List<CartDto> getAllCartItems(Long userId);

    void removeItemFromCart(Long userId, Long cartId);

}
