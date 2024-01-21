package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseholdDTO;
import com.nhnacademy.springjpa.entity.Household;

public interface HouseholdService {
    Household registerHousehold(HouseholdDTO householdDTO);

    void deleteHousehold(Long householdSerialNumber);

    Household findHouseholdBySerialNumber(Long residentSerialNumber);
}
