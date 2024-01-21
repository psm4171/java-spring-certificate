package com.nhnacademy.springjpa.domain;

import java.util.Date;
import lombok.Getter;

@Getter
public class BirthReportDTO {
    private Long residentSerialNumber;
    private String birthDeathType;
    private Long reportResidentSerialNumber;
    private Date birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String eamilAddress;
    private String phoneNumber;

}
