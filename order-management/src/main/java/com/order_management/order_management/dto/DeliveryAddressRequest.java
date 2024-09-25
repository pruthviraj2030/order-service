package com.order_management.order_management.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.order_management.order_management.model.DeliveryAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryAddressRequest {
    public Long id;
    public Long mobileNumber;
    public Long alternateNumber;
    public Long pinCode;
    public String state;
    public String city;
    public String place;
    public String area;
    public String landmark;
    public Boolean isDefault;

    public DeliveryAddressRequest(DeliveryAddress deliveryAddress) {
        new DeliveryAddressRequest(deliveryAddress.getId(),deliveryAddress.getMobileNumber(),
                deliveryAddress.getAlternateNumber(),
                deliveryAddress.getPinCode(),
                deliveryAddress.getState(),
                deliveryAddress.getCity(),
                deliveryAddress.getPlace(),
                deliveryAddress.getArea(),
                deliveryAddress.getLandmark(),
                deliveryAddress.getIsDefault());
    }
}
