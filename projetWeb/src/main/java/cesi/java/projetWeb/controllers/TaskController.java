package cesi.java.projetWeb.controllers;


import cesi.java.projetWeb.Models.Task;
import cesi.java.projetWeb.repositories.TaskRepository;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;


@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/tasks")
    public @ResponseBody
    void insert(@RequestBody Task task) {
        taskRepository.insert(task);
    }


    @PutMapping("/tasks/{id}")
    public @ResponseBody
    void update(@RequestBody Task task, @PathVariable String id) {
        int intId = parseInt(id);
        taskRepository.update(task, intId);
    }

    @DeleteMapping("/tasks/{id}")
    public @ResponseBody
    void delete(@PathVariable String id) {
        int intId = parseInt(id);
        taskRepository.delete(intId);
    }

    @GetMapping("/tasks")
    public @ResponseBody
    String getTasks(Model model)
    {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

 /*   @GetMapping("/tasks/{id}")
    Task getTasks(@PathVariable  String id)
    {
        int intId = Integer.parseInt(id);
        return taskRepository.findOne(intId);

    }*/


   /* @GetMapping("/tasks")
    public @ResponseBody
    List<Task> getTasks(@RequestParam(name = "statusId", required = false) String statusId,
                        @RequestParam(name = "id", required = false) String id) {

        if (StringUtils.hasText(statusId)) {
            int intStatusId = parseInt(statusId);
            return taskRepository.getTasksByStatusId(intStatusId);
        }
        if (StringUtils.hasText(id)) {
            int intId = Integer.parseInt(id);
            return taskRepository.findOne(intId);
        }
        else {
            return taskRepository.findAll();
        }
    }*/
}
