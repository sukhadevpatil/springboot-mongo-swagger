package com.learn.nosql.springbootmongoswagger.controller;

import com.learn.nosql.springbootmongoswagger.entity.Task;
import com.learn.nosql.springbootmongoswagger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/all")
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    @GetMapping("/get/{taskId}")
    public Task getTaskById(@PathVariable String taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable String severity) {
        return taskService.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee) {
        return taskService.getTaskByAssignee(assignee);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task taskReq) {
        return taskService.updateTask(taskReq);
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return taskService.deleteTask(taskId);
    }


}
