package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.HouseholdDTO;
import com.nhnacademy.springjpa.entity.Household;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.repository.HouseholdRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.nhnacademy.springjpa.exception.NotFoundResidentException;

@RequiredArgsConstructor
@Transactional
@Service
public class HouseholdServiceImpl implements HouseholdService{
    private final ResidentRepository residentRepository;
    private final HouseholdRepository householdRepository;

    @Override
    public Household registerHousehold(HouseholdDTO householdDTO) {

        Resident householdResident = residentRepository.findById(householdDTO.getHouseholdResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);

        Household household = new Household().builder()
                .houseHoldResidentSerialNumber(householdResident)
                .houseHoldCompositionDate(householdDTO.getHouseHoldCompositionDate())
                .householdCompositionReasonCode(householdDTO.getHouseholdCompositionReasonCode())
                .currentHouseMovementAddress(householdDTO.getCurrentHouseMovementAddress())
                .householdCompositionResidents(null)
                .houseHoldMovementAddresses(null)
                .build();

        return householdRepository.save(household);
    }

    @Override
    public void deleteHousehold(Long householdSerialNumber) {
        householdRepository.deleteById(householdSerialNumber);
    }

    @Override
    public Household findHouseholdBySerialNumber(Long residentSerialNumber) {
        return householdRepository.findByResidentSerialNumber(residentSerialNumber);
    }
}
