package com.nhnacademy.springjpa.repository;

import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
import com.nhnacademy.springjpa.entity.HouseHoldMovementAddress;

@NoRepositoryBean
public interface HouseholdMovementAddressRepositoryCustom {

    HouseHoldMovementAddress getLastMovementAddress(Long householdSerialNumber);

    List<HouseHoldMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber);
}
