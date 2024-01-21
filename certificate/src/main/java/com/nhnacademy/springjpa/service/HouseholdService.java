package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.entity.Household;

public interface HouseholdService {
    Household registerHousehold();

    void deleteHousehold(Long householdSerialNumber);

    Household findHouseholdBySerialNumber(Long residentSerialNumber);
}
