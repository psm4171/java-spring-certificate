package com.nhnacademy.springjpa.controller.api;

import com.nhnacademy.springjpa.domain.HouseholdDTO;
import com.nhnacademy.springjpa.entity.Household;
import com.nhnacademy.springjpa.service.HouseholdService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/household")
public class HouseholdController {
    private final HouseholdService householdService;

    @PostMapping
    public Household registerHousehold(@RequestBody HouseholdDTO householdDTO){
        return householdService.registerHousehold(householdDTO);
    }

    @DeleteMapping("{householdSerialNumber}")
    public void deleteHousehold(@PathVariable(name = "householdSerialNumber") Long householdSerialNumber){
        householdService.deleteHousehold(householdSerialNumber);
    }
}
