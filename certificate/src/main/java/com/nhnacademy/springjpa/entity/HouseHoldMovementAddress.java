package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "household_movement_address")
@NoArgsConstructor
@Getter
@Setter
public class HouseHoldMovementAddress {

    @EmbeddedId
    Pk pk;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @Column(name = "house_movement_address")
    private String houseMovementAddress;

    @Column(name = "last_address_yn")
    private String lastAddressYn;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Embeddable
    public static class Pk implements Serializable{

        @Column(name = "household_serial_number")
        private Long householdSerialNumber;

        @Column(name = "house_movement_report_date")
        private Date houseMovementReportDate;
    }

}
