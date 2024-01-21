package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
@ToString
@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class CertificateIssue {

    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificateComfirmationNumber;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code")
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date")
    private Date certificateIssueCode;



}
