package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseHoldMovementAddressDTO;
import com.nhnacademy.springjpa.entity.HouseHoldMovementAddress;
import java.util.List;

public interface HouseholdMovementAddressService {
    HouseHoldMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseHoldMovementAddressDTO houseHoldMovementAddressDTO);

    List<HouseHoldMovementAddress> getMovementAddressbyResidentSerialNumber(Long residentSerialNumber);

}
