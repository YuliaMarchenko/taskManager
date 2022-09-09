package com.telran;

import com.telran.engine.TaskManagerImpl;
import com.telran.engine.TasksManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class MyApplication {

    @Bean
    public TasksManager tasksManager() throws SQLException {
        return new TaskManagerImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}

