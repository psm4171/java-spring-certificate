package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.HouseholdMovementAddress;
import com.nhnacademy.springjpa.entity.QHouseholdMovementAddress;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdMovementAddressRepositoryImpl extends QuerydslRepositorySupport implements HouseholdMovementAddressRepositoryCustom {

    public HouseholdMovementAddressRepositoryImpl() {
        super(HouseholdMovementAddress.class);
    }

    @Override
    public HouseholdMovementAddress getLastMovementAddress(Long householdSerialNumber) {
        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;

        return from(householdMovementAddress)
                .select(householdMovementAddress)
                .where(householdMovementAddress.pk.householdSerialNumber.eq(householdSerialNumber))
                .orderBy(householdMovementAddress.pk.houseMovementReportDate.desc())
                .limit(1)
                .fetchOne();
    }

    @Override
    public List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber) {

        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;

        return from(householdMovementAddress)
                .select(householdMovementAddress)
                .where(householdMovementAddress.household.houseHoldResidentSerialNumber.residentSerialNumber.eq(residentSerialNumber))
                .orderBy(householdMovementAddress.lastAddressYn.desc())
                .fetch();
    }
}