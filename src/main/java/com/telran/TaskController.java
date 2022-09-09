package com.telran;

import com.telran.engine.TasksManager;
import com.telran.entities.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TasksManager repository;

    public TaskController(TasksManager repository) {
        this.repository = repository;
    }


    @GetMapping("/tasks")
    List<Task> findNotCompletedTasks(){
        return repository.findNotCompletedTasks();
    }
}
