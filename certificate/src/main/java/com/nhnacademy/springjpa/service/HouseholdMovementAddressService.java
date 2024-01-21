package com.nhnacademy.springjpa.service;
import com.nhnacademy.springjpa.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import java.util.List;

public interface HouseholdMovementAddressService {

    HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressDTO householdMovementAddressDTO);

    List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber);
}