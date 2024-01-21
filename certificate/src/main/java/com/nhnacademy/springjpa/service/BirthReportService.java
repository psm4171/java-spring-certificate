package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.BirthReportDTO;
import com.nhnacademy.springjpa.entity.BirthDeathReportResident;

public interface BirthReportService {
    BirthDeathReportResident registerBirthReport(BirthReportDTO birthReportDTO);
    BirthDeathReportResident modifyBirthReport(Long targetSerialNumber, BirthReportDTO birthReportDTO);
    void deleteBirthReport(Long targetSerialNumber);
}
