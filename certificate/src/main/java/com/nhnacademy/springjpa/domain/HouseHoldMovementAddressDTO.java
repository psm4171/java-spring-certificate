package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.Resident;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class HouseHoldMovementAddressDTO {
    private Long householdSerialNumber;
    private LocalDateTime houseHoldCompositionDate;
    private String houseHoldMovementAddresses;
}
