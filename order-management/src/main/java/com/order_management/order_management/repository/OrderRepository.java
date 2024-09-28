package com.order_management.order_management.repository;

import com.order_management.order_management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderIdAndUserId(Long orderId, Long userId);

    @Query(value = "Select * from order where user_id=:userId and is_cancelled=false and delivered_on is null", nativeQuery = true)
    List<Order> findAllActiveOrders(Long userId);

    List<Order> findAllUserId(Long userId);
}
