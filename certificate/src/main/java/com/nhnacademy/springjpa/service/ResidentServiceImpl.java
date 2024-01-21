package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ResidentModifyDTO;
import com.nhnacademy.springjpa.domain.ResidentRegisterDTO;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import com.nhnacademy.springjpa.exception.NotFoundResidentException;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ResidentServiceImpl implements ResidentService{

    private final ResidentRepository residentRepository;

    @Override
    public Resident registerResident(ResidentRegisterDTO residentRegisterDTO) {
        log.info("Registering new Resident" + residentRegisterDTO);

        Resident resident = new Resident().builder()
                .name(residentRegisterDTO.getName())
                .residentRegistrationNumber(residentRegisterDTO.getResidentRegistrationNumber())
                .genderCode(residentRegisterDTO.getGenderCode())
                .birthDate(residentRegisterDTO.getBirthDate())
                .birthPlaceCode(residentRegisterDTO.getBirthPlaceCode())
                .registrationBaseAddress(residentRegisterDTO.getRegistrationBaseAddress())
                .deathDate(residentRegisterDTO.getDeathDate())
                .deathPlaceCode(residentRegisterDTO.getDeathPlaceCode())
                .deathPlaceAddress(residentRegisterDTO.getDeathPlaceAddress())
                .build();

        return residentRepository.save(resident);
    }

    @Override
    public Resident modifyResident(Long serialNumber, ResidentModifyDTO residentModifyDTO) {

        Resident resident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);

        resident.modifyResidentInfo(
                residentModifyDTO.getName(),
                residentModifyDTO.getRegistrationBaseAddress(),
                residentModifyDTO.getDeathDate(),
                residentModifyDTO.getDeathPlaceCode(),
                residentModifyDTO.getDeathPlaceAddress()
        );

        return residentRepository.save(resident);
    }

    @Override
    public Resident findbySerialNumber(Long serialNumber) {
        return residentRepository.findByResidentSerialNumber(serialNumber).orElseThrow(NotFoundResidentException::new);
    }

    @Override
    public Page<Resident> findAll(Pageable pageable) {

        // Pageable pageable
        log.info("Pagination resident"  + pageable);
        return residentRepository.findAll(pageable);
    }

//    @Override
//    public Resident findByEmail(String email) {
//        return residentRepository.findByEmail(email).orElseThrow(NotFoundResidentException::new);
//    }
}
