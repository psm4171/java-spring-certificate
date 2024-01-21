package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@ToString
@Entity
@Table(name = "household_composition_resident")
@NoArgsConstructor
@Getter
@Setter
public class HouseholdCompositionResident {

    @EmbeddedId
    private Pk pk;

    @MapsId("householdSeiralNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "report_date")
    private Date ReportDate;

    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;

    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasomCode;


    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private Long householdSeiralNumber;

        @Column(name = "resident_serial_number")
        private Long residentSerialNumber;

    }
}
