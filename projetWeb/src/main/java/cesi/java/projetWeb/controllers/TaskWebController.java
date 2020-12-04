package cesi.java.projetWeb.controllers;

import cesi.java.projetWeb.Models.Person;
import cesi.java.projetWeb.Models.Status;
import cesi.java.projetWeb.Models.Task;
import cesi.java.projetWeb.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;


@Controller
public class TaskWebController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/index")
    public String showIndex(Model model) {
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @GetMapping("/edit-tasks/{id}")
    public String editTasks(@PathVariable("id") int id, Model model) {
        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);
        return "edit-tasks";
    }

    @GetMapping("/add-tasks")
    public String addTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "add-tasks";
    }

    @PostMapping("/add-tasks")
    public String postAddTask(@ModelAttribute Task task, Model model) {
        Person person = new Person();
        person.setId(2);
        Status status = new Status();
        status.setId(1);
        task.setPerson(person);
        task.setStatus(status);
        taskRepository.insert(task);
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @PostMapping(value = "/edit-tasks/{id}")
    public String update(@ModelAttribute Task task, Model model, @PathVariable int id) {

        taskRepository.update(task, id);
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        int intId = parseInt(id);
        Task task = taskRepository.findOne(intId);
        taskRepository.delete(intId);
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }


}
