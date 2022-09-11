package com.telran;

import com.telran.engine.TasksManager;
import com.telran.entities.Task;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/tasks/assigned")
    List<Task> findAssignedTasks(@RequestParam String person){
        return repository.findAssignedTasks(person);
    }

    @GetMapping("/tasks/week")
    List<Task> findTasksThisWeekTasks(){
        return repository.findTasksThisWeekTasks();
    }

    @DeleteMapping("/tasks/{name}")
    Map<String, Boolean> deleteTask(@PathVariable String name){
        return result(repository.deleteTask(name));
    }

    @PostMapping( "/tasks")
    Map<String, Boolean> createTask(@RequestBody Task task) {
        return result(repository.createTask(task));
    }

    public Map<String, Boolean> result(boolean answer){
        Map<String, Boolean> result = new HashMap<>();
        result.put("status", answer);
        return result;
    }
}
