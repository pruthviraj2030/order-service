package com.order_management.order_management.model;

import com.order_management.order_management.dto.CartRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private Long id;
    private Long userId;
    private Long productId;
    private Long quantity;

    public Cart(CartRequest cartRequest) {
        this.userId = cartRequest.getUserId();
        this.productId = cartRequest.getProductId();
    }
}
