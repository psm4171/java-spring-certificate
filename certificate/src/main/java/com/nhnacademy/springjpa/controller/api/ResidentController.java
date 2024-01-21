package com.nhnacademy.springjpa.controller.api;

import com.nhnacademy.springjpa.domain.ResidentModifyDTO;
import com.nhnacademy.springjpa.domain.ResidentRegisterDTO;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/residents", produces = "application/json;")
public class ResidentController {

    private final ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService){
        this.residentService = residentService;
    }

    @PostMapping
    public Resident registerResident(@RequestBody ResidentRegisterDTO residentRegisterDTO){
        System.out.println(residentRegisterDTO);

        return residentService.registerResident(residentRegisterDTO);
    }

    @PutMapping("/{serialNumber}")
    public Resident modifyResident(@PathVariable(name = "serialNumber") Long serialNumber,
            @RequestBody ResidentModifyDTO residentModifyDTO){
        System.out.println(residentModifyDTO);

        return residentService.modifyResident(serialNumber, residentModifyDTO);
    }

}
