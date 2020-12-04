package cesi.java.projetWeb.controllers;

import cesi.java.projetWeb.Models.Person;
import cesi.java.projetWeb.Models.Role;
import cesi.java.projetWeb.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static java.lang.Integer.parseInt;


@Controller
public class PersonWebController {

    @Autowired
    private PersonRepository personRepository;

    /*@GetMapping("/index")
    public String showIndex(Model model) {
        return "index";
    }*/

    @GetMapping("/persons")
    public String getPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "persons";
    }

    @GetMapping("/edit-persons/{id}")
    public String editPersons(@PathVariable("id") int id, Model model) {
        Person person = personRepository.findOne(id);
        model.addAttribute("person", person);
        return "edit-persons";
    }

    @GetMapping("/add-persons")
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add-persons";
    }

    @PostMapping("/add-persons")
    public String postAddPerson(@ModelAttribute Person person, Model model) {
        Role role = new Role();
        role.setId(1);
        person.setRole(role);
        personRepository.insert(person);
        model.addAttribute("persons", personRepository.findAll());
        return "persons";
    }

    @PostMapping(value = "/edit-persons/{id}")
    public String update(@ModelAttribute Person person, Model model, @PathVariable int id) {
        Person personInDb = personRepository.findOne(id);
        personInDb.setAlias(person.getAlias());
        personInDb.setName(person.getName());

        personRepository.update(personInDb, id);

        return "redirect:/persons";
    }

    @GetMapping("/delete-person/{id}")
    public String delete(@PathVariable String id, Model model) {
        int intId = parseInt(id);
        Person person = personRepository.findOne(intId);
        personRepository.delete(intId);
        model.addAttribute("persons", personRepository.findAll());
        return "persons";
    }


}
