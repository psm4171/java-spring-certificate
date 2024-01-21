package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ResidentModifyDTO;
import com.nhnacademy.springjpa.domain.ResidentRegisterDTO;
import com.nhnacademy.springjpa.entity.Resident;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ResidentService {

    Resident registerResident(ResidentRegisterDTO residentRegisterDTO);

    Resident modifyResident(Long serialNumber, ResidentModifyDTO residentModifyDTO);
    Resident findbySerialNumber(Long serialNumber);


   Page<Resident> findAll(Pageable pageable);

 //   Resident findByEmail(String email);

}
