package com.order_management.order_management.repository;

import com.order_management.order_management.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {


    Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);

    List<Cart> findByUserId(Long userId);

    Optional<Cart> findByIdAndUserId(Long cartId, Long userId);

}
