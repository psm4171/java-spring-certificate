package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import java.util.List;

public interface HouseholdCompositionResidentRepositoryCustom {
    List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber);
}
