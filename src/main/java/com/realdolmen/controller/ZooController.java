package com.realdolmen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZooController {

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping(value ="/about")
    public String showAboutPage(){
        return "about";
    }

}
