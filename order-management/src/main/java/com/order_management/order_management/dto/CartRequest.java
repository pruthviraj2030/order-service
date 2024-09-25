package com.order_management.order_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    public Long userId;
    public Long productId;
    public Long quantity;
}
