package com.order_management.order_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "delivery_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {

    @Id
    private Long id;
    private Long userId;
    private Long mobileNumber;
    private Long alternateNumber;
    private Long pinCode;
    private String state;
    private String city;
    private String place;
    private String area;
    private String landmark;
    private Boolean isDefault;



}
