package cesi.java.projetWeb.controllers;

import cesi.java.projetWeb.Models.Person;
import cesi.java.projetWeb.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    List<Person> All()  {
        return personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public @ResponseBody
    Person One(@PathVariable("id") String id) {
        int intId = Integer.parseInt(id);
        return personRepository.findOne(intId);
    }

    @PostMapping("/persons")
    public @ResponseBody
    void insert(@RequestBody Person person) {
        personRepository.insert(person);
    }

}
