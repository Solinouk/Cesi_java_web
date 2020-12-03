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

    // Mapping all persons
    @GetMapping("/persons")
    List<Person> All()  {
        return personRepository.findAll();
    }

    // Mapping get one person by Id
    @GetMapping(value="/persons",params = "id")
    public @ResponseBody
    Person One(@RequestParam(name = "id") String id) {
        int intId = Integer.parseInt(id);
        return personRepository.findOne(intId);
    }

    // Mapping get list by RoleId
    @GetMapping(value = "/persons", params = "roleId")
    public @ResponseBody
    List<Person> ByRoleId(@RequestParam(name = "roleId") String roleId) {
        int intRoleId = Integer.parseInt(roleId);
        return personRepository.getPersonByRoleId(intRoleId);
    }

    @PostMapping("/persons")
    public @ResponseBody
    void insert(@RequestBody Person person) {
        personRepository.insert(person);
    }

    @PutMapping(value = "/persons",params = "id")
    public @ResponseBody
    void update(@RequestBody Person person,  @RequestParam(name = "id") String id) {
        int intId = Integer.parseInt(id);
        personRepository.update(person, intId);
    }

    @DeleteMapping(value = "/persons", params = "id")
    public @ResponseBody
    void delete(@RequestParam(name="id") String id) {
        int intId = Integer.parseInt(id);
        personRepository.delete(intId);
    }

}
