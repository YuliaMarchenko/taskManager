package com.telran;

import com.telran.engine.TaskManagerImpl;
import com.telran.entities.Task;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskManagerImpl taskManager = new TaskManagerImpl();
//        Task taskNew = Task.builder()
//                .name("name today")
//                .assignedPerson("Roman")
//                .completionDate(LocalDate.of(2022,9,6))
//                .isCompleted(false)
//                .createdDate(LocalDate.of(2022,9,5))
//                .build();
//
//        taskManager.createTask(taskNew);

//        for (Task task:taskManager.findNotCompletedTasks()
//             ) {
//            System.out.println(task.getName());
//        }

//        for (Task task:taskManager.findAssignedTasks("Roman")
//        ) {
//            System.out.println(task.getName());
//        }

//        for(Task task : taskManager.findTasksThisWeekTasks()){
//            System.out.println(task.getName());
//        }

        taskManager.deleteTask("name today");

    }
}
