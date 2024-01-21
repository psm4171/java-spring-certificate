package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import java.util.List;

public interface HouseholdCompositionResidentService {
    List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber);
}
