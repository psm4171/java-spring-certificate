package com.nhnacademy.springjpa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HomeController {

    //@RequestMapping(method = RequestMethod.GET, value = {"/index.html"})
    @GetMapping("/")
    public String home(){

        log.info("HomeController - index");
        return "views/index";
    }
}
