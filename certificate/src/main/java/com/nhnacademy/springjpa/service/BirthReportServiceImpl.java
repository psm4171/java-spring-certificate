package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.BirthReportDTO;
import com.nhnacademy.springjpa.entity.BirthDeathReportResident;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.exception.NotFoundResidentException;
import com.nhnacademy.springjpa.repository.BirthReportRepository;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import java.util.Objects;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class BirthReportServiceImpl implements BirthReportService{

    private final ResidentRepository residentRepository;
    private final BirthReportRepository birthReportRepository;
    private static final String BIRTH_TYPE = "출생";
    @Override
    public BirthDeathReportResident registerBirthReport(BirthReportDTO birthReportDTO) {

        Resident reportResident = residentRepository.findById(birthReportDTO.getReportResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);
        Resident targetResident = residentRepository.findById(birthReportDTO.getResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident().builder()
                .pk(new BirthDeathReportResident.Pk(targetResident.getResidentSerialNumber(), birthReportDTO.getBirthDeathType()))
                .resident(targetResident)
                .reportResidentSerialNumber(reportResident)
                .birthDeathReportDate(birthReportDTO.getBirthDeathReportDate())
                .birthReportQualificationsCode(birthReportDTO.getBirthReportQualificationsCode())
                .eamilAddress(birthReportDTO.getEamilAddress())
                .phoneNumber(birthReportDTO.getPhoneNumber())
                .build();

        return birthReportRepository.save(birthDeathReportResident);

    }

    @Override
    public BirthDeathReportResident modifyBirthReport(Long targetSerialNumber, BirthReportDTO birthReportDTO) {

        BirthDeathReportResident birthReport = birthReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, BIRTH_TYPE);

        if(Objects.isNull(birthReport)){
            throw new NotFoundResidentException();
        }

        birthReport.updateReportInfo(birthReportDTO.getEamilAddress(), birthReportDTO.getPhoneNumber());

        return birthReportRepository.save(birthReport);
    }

    @Override
    public void deleteBirthReport(Long targetSerialNumber) {
        birthReportRepository.deleteByPk_ResidentSerialNumberAndPk_BirthDeathTyCode(targetSerialNumber, BIRTH_TYPE);
    }
}
