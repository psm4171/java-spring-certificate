package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseHoldMovementAddress;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseHoldMovementAddress, HouseHoldMovementAddress.Pk>, HouseholdMovementAddressRepositoryCustom {
    List<HouseHoldMovementAddress> findByPk_HouseholdSerialNumber(Long householdSerialNumber);

}
