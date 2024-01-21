package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@ToString
@Entity
@Table(name = "household_movement_address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HouseholdMovementAddress {

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


    @ToString
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
