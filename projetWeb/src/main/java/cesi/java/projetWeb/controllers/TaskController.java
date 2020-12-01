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

  /*  @PostMapping("/tasks")
    Task task(@RequestBody Task task) {
        return TaskRepository.save(task);
    }*/


}
