package com.realdolmen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping(value = "/contactpage")
    public String contactPage(){
        return "contact";
    }
}
