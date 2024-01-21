package com.nhnacademy.springjpa.service;


import com.nhnacademy.springjpa.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import com.nhnacademy.springjpa.entity.Household;
import com.nhnacademy.springjpa.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.springjpa.repository.HouseholdRepository;
import com.nhnacademy.springjpa.exception.NoSuchElementException;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class HouseholdMovementAddressServiceImpl implements HouseholdMovementAddressService {

    private final HouseholdRepository householdRepository;
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    @Transactional
    @Override
    public HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressDTO houseHoldMovementAddressDTO) {
        HouseholdMovementAddress lastMovementAddress = householdMovementAddressRepository.getLastMovementAddress(householdSerialNumber);
        lastMovementAddress.setLastAddressYn("N");

        householdMovementAddressRepository.save(lastMovementAddress);

        Household household = householdRepository.findById(householdSerialNumber).orElseThrow(NoSuchElementException::new);

        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress().builder()
                .pk(new HouseholdMovementAddress.Pk(householdSerialNumber, houseHoldMovementAddressDTO.getHouseMovementReportDate()))
                .household(household)
                .houseMovementAddress(houseHoldMovementAddressDTO.getHouseholdMovementAddresses())
                .lastAddressYn("Y")
                .build();

        return householdMovementAddressRepository.save(householdMovementAddress);
    }


    @Override
    public List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber) {
        return householdMovementAddressRepository.getMovementAddressByResidentSerialNumber(residentSerialNumber);
    }
}
