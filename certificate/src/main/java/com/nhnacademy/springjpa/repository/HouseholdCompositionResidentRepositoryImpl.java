package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseholdCompositionResident;
import com.nhnacademy.springjpa.entity.QHouseholdCompositionResident;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdCompositionResidentRepositoryImpl extends QuerydslRepositorySupport implements HouseholdCompositionResidentRepositoryCustom {

   public HouseholdCompositionResidentRepositoryImpl(){
       super(HouseholdCompositionResident.class);
   }
    @Override
    public List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber) {

        QHouseholdCompositionResident householdCompositionResident = QHouseholdCompositionResident.householdCompositionResident;

       return from(householdCompositionResident)
               .select(householdCompositionResident)
               .where(householdCompositionResident.household.houseHoldResidentSerialNumber.residentSerialNumber.eq(residentSerialNumber))
               .fetch();
    }
}
