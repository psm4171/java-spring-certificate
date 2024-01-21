package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HouseholdMovementAddressRepositoryCustom {

    HouseholdMovementAddress getLastMovementAddress(Long householdSerialNumber);

    List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber);
}

