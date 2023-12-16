package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Tasks;
import com.example.demo.request.TaskCreateRequest;
import com.example.demo.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Tasks createTask(@RequestBody TaskCreateRequest taskCreateRequest) {
        return taskService.saveTask(taskCreateRequest);
    }

    @GetMapping("/{taskId}")
    public Tasks getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public Tasks updateTask(@PathVariable Long taskId, @RequestBody TaskCreateRequest taskCreateRequest) {
        return taskService.updateTask(taskId, taskCreateRequest);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
