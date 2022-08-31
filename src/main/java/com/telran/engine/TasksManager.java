package com.telran.engine;

import com.telran.entities.Task;

import java.util.List;

public interface TasksManager {
    boolean createTask(Task task);
    List<Task> findNotCompletedTasks();
    List<Task> findAssignedTasks(String person);
    List<Task> findTasksThisWeekTasks();
    boolean deleteTask(String taskName);
}
