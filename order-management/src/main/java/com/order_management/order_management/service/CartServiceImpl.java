package com.order_management.order_management.service;

import com.order_management.order_management.dto.CartDto;
import com.order_management.order_management.dto.CartRequest;
import com.order_management.order_management.model.Cart;
import com.order_management.order_management.repository.CartRepository;
import com.order_management.order_management.service.contract.CartService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public CartDto addToCart(CartRequest cartRequest) {
        try {
            Cart cart = cartRepository.findByUserIdAndProductId(cartRequest.getUserId(), cartRequest.getProductId())
                    .orElse(new Cart(cartRequest));
            if (Objects.nonNull(cartRequest.getQuantity()))
                cart.setQuantity(cart.getQuantity());
            cart = cartRepository.save(cart);
            return new CartDto(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CartDto> getAllCartItems(Long userId) {
        try {
            List<Cart> listOfItems = cartRepository.findByUserId(userId);
            if (CollectionUtils.isEmpty(listOfItems))
                return listOfItems.stream().map(CartDto::new).collect(Collectors.toList());
            return Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeItemFromCart(Long userId, Long cartId) {
        try {
            Cart cart = cartRepository.findByIdAndUserId(cartId, userId)
                    .orElseThrow(() -> new RuntimeException("Item Not Present"));
            cartRepository.delete(cart);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
