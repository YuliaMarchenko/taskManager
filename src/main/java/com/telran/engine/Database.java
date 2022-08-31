package com.telran.engine;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Getter

public class Database {
    private Connection conn;

    public Database() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "tasks");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", connectionProps);
        System.out.println("Connected to database");
    }
}
