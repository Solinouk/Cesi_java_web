package cesi.java.projetWeb.controllers;


import cesi.java.projetWeb.Models.Task;
import cesi.java.projetWeb.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private TaskRepository taskRepository;

       public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    List<Task> All()  {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public @ResponseBody
    Task One(@PathVariable("id") String id) {
        int intId = Integer.parseInt(id);
        return taskRepository.findOne(intId);
    }

    @PostMapping("/tasks")
    public @ResponseBody
    void insert(@RequestBody Task task) {
        taskRepository.insert(task);
    }


}
