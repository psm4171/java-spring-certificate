package com.nhnacademy.springjpa.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class HouseholdDTO {
    private Long householdResidentSerialNumber;
    private LocalDateTime houseHoldCompositionDate;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;

}
