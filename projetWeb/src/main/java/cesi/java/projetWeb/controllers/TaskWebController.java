package cesi.java.projetWeb.controllers;

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
    private  TaskRepository taskRepository;

    @GetMapping("/index")
    public  String showIndex(Model model)
    {
        return "index";
    }

    @GetMapping("/tasks")
    public  String getTasks(Model model)
    {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @GetMapping("/edit-tasks/{id}")
    public  String editTasks(@PathVariable("id") int id, Model model )
    {
        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);
        return "edit-tasks";
    }

    @GetMapping("/add-tasks")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "add-tasks";
    }

    @PostMapping("/add-tasks")
    public  String postAddTask(@ModelAttribute Task task, Model model) {

        taskRepository.insert(task);
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @PutMapping(value = "/edit-tasks/{id}")
    public String update(@ModelAttribute Task task, Model model,@PathVariable int id) {

        taskRepository.update(task, id);
        model.addAttribute("tasks",taskRepository.findAll());
        return "tasks";
    }

}
