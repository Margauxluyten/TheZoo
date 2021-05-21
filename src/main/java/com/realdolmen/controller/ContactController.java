package com.realdolmen.controller;

import com.realdolmen.domain.Contact;
import com.realdolmen.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class ContactController {
    ContactService contactService = new ContactService();

    @GetMapping(value = "/contactpage")
    public String contactPage(Model model){
        model.addAttribute("newcontact",new Contact());
        return "contact";
    }

    @PostMapping(value = "/savecontact")
    public String saveContact(@ModelAttribute Contact newContact) throws SQLException{
        contactService.saveContact(newContact);
        return "redirect:/";
    }
}
