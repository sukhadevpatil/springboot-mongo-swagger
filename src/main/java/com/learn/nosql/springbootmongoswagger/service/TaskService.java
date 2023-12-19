package com.learn.nosql.springbootmongoswagger.service;

import com.learn.nosql.springbootmongoswagger.entity.Task;
import com.learn.nosql.springbootmongoswagger.respository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(String taskId) {
        return taskRepository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(String severity) {
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    public Task updateTask(Task taskReq) {
        Task existingTask = taskRepository.findById(taskReq.getTaskId()).get();
        existingTask.setSeverity(taskReq.getSeverity());
        existingTask.setDescription(taskReq.getDescription());
        existingTask.setStoryPoint(taskReq.getStoryPoint());
        existingTask.setAssignee(taskReq.getAssignee());

        return taskRepository.save(existingTask);
    }

    public String deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
        return "Task "+ taskId +" has been deleted...";
    }
}
