package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "birth_death_report_resident")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BirthDeathReportResident {

    @EmbeddedId
    private Pk pk;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @ManyToOne
    @JoinColumn(name = "report_resident_serial_number")
    private Resident reportResidentSerialNumber;

    @Column(name = "birth_death_report_date")
    private Date birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;

    @Column(name = "email_address")
    private String eamilAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable{
        @Column(name = "resident_serial_number")
        private Long residentSerialNumber;

        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;
    }

    public void updateReportInfo(String eamilAddress, String phoneNumber){
        if(eamilAddress != null){
            this.eamilAddress = eamilAddress;
        }

        if(phoneNumber != null){
            this.phoneNumber = phoneNumber;
        }
    }


}
