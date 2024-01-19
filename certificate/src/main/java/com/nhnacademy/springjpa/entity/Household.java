package com.nhnacademy.springjpa.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "household")
@NoArgsConstructor
@Getter
@Setter
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @Column(name = "household_resident_serial_number")
    private Long houseHoldResidentSerialNumber;

    @Column(name = "household_composition_date")
    private Date houseHoldCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

}
