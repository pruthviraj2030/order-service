package com.order_management.order_management.controller;

import com.order_management.order_management.dto.DeliveryAddressRequest;
import com.order_management.order_management.service.contract.DeliveryAddressService;
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
@RequestMapping("/v1/address/user")
@RequiredArgsConstructor
public class AddressController {

    private final DeliveryAddressService deliveryAddressService;

    @PutMapping
    public ResponseEntity<Void> addNewAddress(@RequestBody DeliveryAddressRequest deliveryAddressRequest){
        try{
            deliveryAddressService.addNewAddress(deliveryAddressRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }


    @GetMapping("/{userId}/getAllDeliveryAddress")
    public ResponseEntity<List<DeliveryAddressRequest>> getAllUserDeliveryAddress(@PathVariable Long userId){
        try{
            return new ResponseEntity<>(deliveryAddressService.getAllUserDeliveryAddress(userId), HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }


}
