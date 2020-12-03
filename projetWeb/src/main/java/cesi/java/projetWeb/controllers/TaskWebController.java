package cesi.java.projetWeb.controllers;

import cesi.java.projetWeb.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
