package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.Resident;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;

@Getter
public class HouseHoldMovementAddressDTO {
    private Long householdSerialNumber;
    private Date houseMovementReportDate;
    private String houseHoldMovementAddresses;
}
