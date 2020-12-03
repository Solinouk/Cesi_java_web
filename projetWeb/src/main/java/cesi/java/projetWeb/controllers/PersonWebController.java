package cesi.java.projetWeb.controllers;

import cesi.java.projetWeb.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonWebController {

    @Autowired
    private  PersonRepository personRepository;

    @GetMapping("/persons")
    public  String getPersons(Model model)
    {
        model.addAttribute("persons", personRepository.findAll());
        return "persons";
    }

    @GetMapping("/addPersons")
    public String addPersons(Model model) {
        model.addAttribute("addPersons");
        return "addPersons";
    }
}