package com.nhnacademy.springjpa.controller.api;

import com.nhnacademy.springjpa.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import com.nhnacademy.springjpa.service.HouseholdMovementAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/household/{householdSerialNumber}/movement")
public class HouseholdMovementAddressController {

    private final HouseholdMovementAddressService householdMovementAddressService;

    @PostMapping
    public HouseholdMovementAddress registerHouseholdMovementAddress(@PathVariable(name = "householdSerialNumber") Long householdSerialNumber,
                                                                     @RequestBody HouseholdMovementAddressDTO houseHoldMovementAddressDTO){

        return householdMovementAddressService.registerHouseholdMovementAddress(householdSerialNumber, houseHoldMovementAddressDTO);
    }

}
