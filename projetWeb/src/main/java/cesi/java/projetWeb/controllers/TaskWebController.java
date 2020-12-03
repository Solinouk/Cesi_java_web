package cesi.java.projetWeb.controllers;

import cesi.java.projetWeb.Models.Task;
import cesi.java.projetWeb.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TaskWebController {

    @Autowired
    private  TaskRepository taskRepository;

    @GetMapping("/tasks")
    public  String getTasks(Model model)
    {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
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


}
