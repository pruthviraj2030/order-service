package com.order_management.order_management.dto;

import com.order_management.order_management.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    public Long id;
    public Long userId;
    public Long productId;
    public Long userAddressId;
    public Long quantity;
    public Date createdOn;
    public Boolean isCancelled;
    public Date DeliveredOn;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.userId = order.getUserId();
        this.productId = order.getProductId();
        this.userAddressId = order.getUserAddressId();
        this.quantity = order.getQuantity();
        this.createdOn = order.getCreatedOn();
    }
}
