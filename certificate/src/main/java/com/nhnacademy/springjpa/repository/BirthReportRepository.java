package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.BirthReportDTO;
import com.nhnacademy.springjpa.entity.BirthDeathReportResident;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthReportRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk>{

    BirthDeathReportResident findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(Long residentSerialNumber, String birthDeathType);

    @Transactional
    void deleteByPk_ResidentSerialNumberAndPk_BirthDeathTyCode(Long residentSerialNumber, String birthDeathType);
}
