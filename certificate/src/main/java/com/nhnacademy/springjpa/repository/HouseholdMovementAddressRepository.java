package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk>, HouseholdMovementAddressRepositoryCustom {

    List<HouseholdMovementAddress> findByPk_HouseholdSerialNumber(Long householdSerialNumber);
}
