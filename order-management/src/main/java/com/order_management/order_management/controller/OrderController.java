package com.order_management.order_management.controller;

import com.order_management.order_management.dto.OrderDTO;
import com.order_management.order_management.service.contract.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<Void> createOrders(@RequestBody List<OrderDTO> orderDTOs){
        try {
            orderService.createOrders(orderDTOs);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId, @RequestBody OrderDTO orderDTO){
        try {
            orderService.cancelOrder(orderId,orderDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/user/{userId}/getAllActiveOrders")
    public ResponseEntity<List<OrderDTO>> getAllActiveOrders(@PathVariable Long userId){
        try {
            return new ResponseEntity<>(orderService.getAllActiveOrders(userId), HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }
    @GetMapping("/user/{userId}/getAllOrders")
    public ResponseEntity<List<OrderDTO>> getAllOrders(@PathVariable Long userId){
        try {
            return new ResponseEntity<>(orderService.getAllOrders(userId), HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }



}
