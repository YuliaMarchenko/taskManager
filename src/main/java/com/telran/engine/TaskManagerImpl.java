package com.telran.engine;

import com.telran.entities.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl implements TasksManager{
    private Database db;
    private static final String SQL_INSERT = "INSERT INTO TASKS (name, isCompleted, assignedPerson, createdDate, completionDate) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_NOT_COMPLETED = "SELECT * FROM TASKS WHERE isCompleted IS FALSE";
    private static final String SQL_SELECT_ASSIGNED_PERSON = "SELECT * FROM TASKS WHERE assignedPerson = ?";


    public TaskManagerImpl() throws SQLException {
        this.db = new Database();
    }

    @Override
    public boolean createTask(Task task){
        Connection conn = db.getConn();
        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, task.getName());
            preparedStatement.setBoolean(2, task.isCompleted());
            preparedStatement.setString(3, task.getAssignedPerson());
            preparedStatement.setDate(4, Date.valueOf(task.getCreatedDate()));
            preparedStatement.setDate(5, Date.valueOf(task.getCompletionDate()));
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    task.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException ex){
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Task> findNotCompletedTasks() {
        List<Task> tasks = new ArrayList<>();
        try(Connection conn = db.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_NOT_COMPLETED);
        ) {
            extractTasks(rs, tasks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<Task> findAssignedTasks(String person) {
        List<Task> tasks = new ArrayList<>();
        try(Connection conn = db.getConn();
            PreparedStatement  preparedStatement = conn.prepareStatement(SQL_SELECT_ASSIGNED_PERSON);
        ) {
            preparedStatement.setString(1,person);
            ResultSet rs = preparedStatement.executeQuery();
            extractTasks(rs, tasks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private void extractTasks(ResultSet rs, List<Task> tasks) throws SQLException {
        while(rs.next()){
            Task task = Task.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .isCompleted(rs.getBoolean("isCompleted"))
                    .assignedPerson(rs.getString("assignedPerson"))
                    .createdDate(rs.getDate("createdDate").toLocalDate())
                    .completionDate(rs.getDate("completionDate").toLocalDate())
                    .build();
            tasks.add(task);
        }
    }

    @Override
    public List<Task> findTasksThisWeekTasks() {
        return null;
    }

    @Override
    public boolean deleteTask(String taskName) {
        return false;
    }
}
