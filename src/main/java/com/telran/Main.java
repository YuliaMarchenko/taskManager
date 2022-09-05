package com.telran;

import com.telran.engine.TaskManagerImpl;
import com.telran.entities.Task;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskManagerImpl taskManager = new TaskManagerImpl();
//        Task task = Task.builder()
//                .name("name 10")
//                .assignedPerson("Roman")
//                .completionDate(LocalDate.of(2019,11,13))
//                .isCompleted(false)
//                .createdDate(LocalDate.of(2021,11,13))
//                .build();
//
//        taskManager.createTask(task);
//        System.out.println(task.getId());

        for (Task task:taskManager.findNotCompletedTasks()
             ) {
            System.out.println(task.getName());
        }

    }
}
