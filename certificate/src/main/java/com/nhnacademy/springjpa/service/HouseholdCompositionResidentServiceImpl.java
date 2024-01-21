package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import com.nhnacademy.springjpa.repository.HouseholdCompositionResidentRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class HouseholdCompositionResidentServiceImpl implements HouseholdCompositionResidentService{
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    public HouseholdCompositionResidentServiceImpl(HouseholdCompositionResidentRepository householdCompositionResidentRepository) {
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
    }

    @Override
    public List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber) {
        return getHouseholdCompositionByHouseholdResidentSerialNumber(residentSerialNumber);

     //   return householdCompositionResidentRepository.getHouseholdCompositionByHouseholdResidentSerialNumber(residentSerialNumber);

    }
}
