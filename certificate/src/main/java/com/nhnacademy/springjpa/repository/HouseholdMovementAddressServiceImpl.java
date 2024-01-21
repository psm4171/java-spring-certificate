package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.HouseHoldMovementAddressDTO;
import com.nhnacademy.springjpa.entity.HouseHoldMovementAddress;
import com.nhnacademy.springjpa.entity.Household;
import com.nhnacademy.springjpa.service.HouseholdMovementAddressService;
import java.util.List;
import java.util.NoSuchElementException;
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
    public HouseHoldMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseHoldMovementAddressDTO houseHoldMovementAddressDTO) {

        HouseHoldMovementAddress lastMovementAddress = householdMovementAddressRepository.getLastMovementAddress(householdSerialNumber);
        lastMovementAddress.setLastAddressYn("N");

        householdMovementAddressRepository.save(lastMovementAddress);

        Household household = householdRepository.findById(householdSerialNumber).orElseThrow(NoSuchElementException::new);

        HouseHoldMovementAddress houseHoldMovementAddress = new HouseHoldMovementAddress().builder()
                .pk(new HouseHoldMovementAddress.Pk(householdSerialNumber, houseHoldMovementAddressDTO.getHouseMovementReportDate()))
                .household(household)
                .houseMovementAddress(houseHoldMovementAddressDTO.getHouseHoldMovementAddresses())
                .lastAddressYn("Y")
                .build();

        return householdMovementAddressRepository.save(houseHoldMovementAddress);
    }

    @Override
    public List<HouseHoldMovementAddress> getMovementAddressbyResidentSerialNumber(Long residentSerialNumber) {
        return householdMovementAddressRepository.getMovementAddressByResidentSerialNumber(residentSerialNumber);
    }
}
