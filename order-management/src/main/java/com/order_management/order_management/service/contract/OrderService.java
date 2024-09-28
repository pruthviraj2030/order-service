package com.order_management.order_management.service.contract;

import com.order_management.order_management.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void createOrders(List<OrderDTO> orderDTO);

    void cancelOrder(Long orderId, OrderDTO orderDTO);

    List<OrderDTO> getAllActiveOrders(Long userId);

    List<OrderDTO> getAllOrders(Long userId);
}
