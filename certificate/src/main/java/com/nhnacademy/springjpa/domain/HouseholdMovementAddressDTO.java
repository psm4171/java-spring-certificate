package com.nhnacademy.springjpa.domain;

import java.util.Date;
import lombok.Getter;

@Getter
public class HouseholdMovementAddressDTO {
    private Long householdSerialNumber;
    private Date houseMovementReportDate;
    private String householdMovementAddresses;
}
