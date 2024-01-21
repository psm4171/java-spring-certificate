package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HouseholdRepository extends JpaRepository<Household, Long> {

    @Query("select h from Household h where h.houseHoldResidentSerialNumber.residentSerialNumber = ?1")
    Household findByResidentSerialNumber(@Param("residentSerialNumber") Long residentSerialNumber);
}
