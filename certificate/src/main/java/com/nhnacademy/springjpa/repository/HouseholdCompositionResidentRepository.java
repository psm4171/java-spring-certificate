package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Household;
import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import com.nhnacademy.springjpa.service.HouseholdCompositionResidentService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
}
