package com.realdolmen.controller;

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.TigerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TigerController {

    TigerService tigerService = new TigerService();

    @GetMapping(value = "/tigertable")
    public String tigerPage(Model model) {
        model.addAttribute("alltigers",tigerService.getTigers());
        return "tigers";
    }

    @GetMapping(value = "/editPage/{id}")
    public String showEditPage(@PathVariable("id") int id, Model model){
        model.addAttribute("countries",tigerService.getCountries());
        model.addAttribute("editanimal",tigerService.findById(id));
        return "edit";
    }


    @PostMapping(value = "/editPage/{id}")
    public String editTiger(@ModelAttribute Tiger tiger) {
        tigerService.editTiger(tiger);
        return "redirect:/";
    }


    @GetMapping(value = "/addtigers")
    public String addTigerPage(Model model) {
        model.addAttribute("countries",tigerService.getCountries());
        model.addAttribute("newtiger", new Tiger());
        return "addtigers";
    }


    @PostMapping(value = "/savetiger")
    public String saveTiger(@ModelAttribute Tiger newTiger) {
        tigerService.addATiger(newTiger);
        return "redirect:/";
    }

    @GetMapping(value= "/delete/{tigerId}")
    public String deleteAGame(@PathVariable("tigerId")int id){
        tigerService.deleteTiger(id);
        return "redirect:/";
    }

}
