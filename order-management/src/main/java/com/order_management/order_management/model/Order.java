package com.order_management.order_management.model;

import com.order_management.order_management.dto.OrderDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private Long id;
    private Long userId;
    private Long productId;
    private Long userAddressId;
    private Long quantity;
    private Date createdOn;
    private Boolean isCancelled;
    private Date DeliveredOn;

    public Order(OrderDTO orderDTO){
        this.userId= orderDTO.getUserId();
        this.isCancelled=false;
        this.productId=orderDTO.getProductId();
        this.quantity= orderDTO.getQuantity();
        this.userAddressId=orderDTO.getUserAddressId();
        this.createdOn=new Date();
    }
}
