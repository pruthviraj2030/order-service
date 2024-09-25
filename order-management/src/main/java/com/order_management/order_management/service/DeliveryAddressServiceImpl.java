package com.order_management.order_management.service;

import com.order_management.order_management.dto.DeliveryAddressRequest;
import com.order_management.order_management.model.DeliveryAddress;
import com.order_management.order_management.repository.DeliveryAddressRepository;
import com.order_management.order_management.service.contract.DeliveryAddressService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    @Override
    public List<DeliveryAddressRequest> getAllUserDeliveryAddress(Long userId) {
        try {
            List<DeliveryAddress> deliveryAddresses = deliveryAddressRepository.findAllByUserId(userId);
            if (CollectionUtils.isEmpty(deliveryAddresses))
                return Collections.emptyList();
            return deliveryAddresses.stream().map(DeliveryAddressRequest::new).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewAddress(DeliveryAddressRequest deliveryAddressRequest) {
        try {
            if(Objects.nonNull(deliveryAddressRequest.getId())) {
                DeliveryAddress deliveryAddress = deliveryAddressRepository.findById(deliveryAddressRequest.getId())
                        .orElseThrow(()->new RuntimeException("Invalid Address"));

                deliveryAddress.setCity(deliveryAddressRequest.getCity());
                deliveryAddress.setArea(deliveryAddressRequest.getArea());
                deliveryAddress.setAlternateNumber(deliveryAddressRequest.getAlternateNumber());
                deliveryAddress.setMobileNumber(deliveryAddressRequest.getMobileNumber());
                deliveryAddress.setLandmark(deliveryAddress.getLandmark());
                deliveryAddress.setState(deliveryAddressRequest.getState());
                deliveryAddress.setPlace(deliveryAddressRequest.getPlace());
                deliveryAddress.setPinCode(deliveryAddressRequest.getPinCode());

                if (BooleanUtils.isTrue(deliveryAddressRequest.isDefault)) {

                    deliveryAddressRepository.findByIdAndIsDefault(deliveryAddressRequest.getId())
                    deliveryAddress.setIsDefault(true);
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
