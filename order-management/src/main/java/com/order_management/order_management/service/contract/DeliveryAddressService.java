package com.order_management.order_management.service.contract;

import com.order_management.order_management.dto.DeliveryAddressRequest;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddressRequest> getAllUserDeliveryAddress(Long userId);

    void addNewAddress(DeliveryAddressRequest deliveryAddressRequest);
}
