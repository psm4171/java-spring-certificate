package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.service.ResidentService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class HomeController {

    private final ResidentService residentService;

    public HomeController(ResidentService residentService) {
        this.residentService = residentService;
    }

    //@RequestMapping(method = RequestMethod.GET, value = {"/index.html"})
    @GetMapping("/")
    public String home(){

        log.info("HomeController - index");
        return "views/index";
    }

//    @ModelAttribute(value="residents")
//    public Page<Resident> getAllResidents(Pageable pageable){
//        Page<Resident> allResidents = residentService.findAll(pageable);
//
//        return allResidents;
//    }
}
