package com.order_management.order_management.service;

import com.order_management.order_management.dto.OrderDTO;
import com.order_management.order_management.model.Order;
import com.order_management.order_management.repository.OrderRepository;
import com.order_management.order_management.service.contract.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrders(List<OrderDTO> orderDTOs) {
        try {
            Set<Order> collect = orderDTOs.stream().map(Order::new).collect(Collectors.toSet());

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void cancelOrder(Long orderId, OrderDTO orderDTO) {
        try {
            if (Objects.isNull(orderId) || Objects.isNull(orderDTO.getUserId()))
                throw new RuntimeException("Invalid Details");

            Order order = orderRepository.findByOrderIdAndUserId(orderId, orderDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("Invalid Details"));
            order.setIsCancelled(true);
            orderRepository.save(order);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<OrderDTO> getAllActiveOrders(Long userId) {
        try {
            if (Objects.isNull(userId))
                return Collections.emptyList();
            List<Order> orders =  orderRepository.findAllActiveOrders(userId);
            return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<OrderDTO> getAllOrders(Long userId) {
        try {
            if (Objects.isNull(userId))
                return Collections.emptyList();
            List<Order> orders =  orderRepository.findAllUserId(userId);
            return orders.stream().map(this::build).collect(Collectors.toList());
        } catch (Exception e) {
            throw e;
        }
    }
    private OrderDTO build(Order order) {
        return new OrderDTO(order.getId(), order.getUserId(), order.getProductId(), order.getUserAddressId()
                ,order.getQuantity(), order.getCreatedOn(),order.getIsCancelled(),order.getDeliveredOn());
    }
}
