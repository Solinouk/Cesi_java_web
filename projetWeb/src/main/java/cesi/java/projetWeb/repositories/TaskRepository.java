package cesi.java.projetWeb.repositories;

import cesi.java.projetWeb.Models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbc;

    ResultSet rs;
    Connection conn;
    Statement st;



    public List<Task> findAll() {

        String sql = "SELECT id, taskname, creationdate, updatedon, statusid, personid FROM task";
        List<Task> tasks = jdbc.query(
                sql,
                new BeanPropertyRowMapper(Task.class));

        return tasks;
    }

    public Task findOne(int id) {
        String sql = "SELECT id, taskname, creationdate, updatedon, statusid, personid FROM task WHERE id = ?";

        return (Task) jdbc.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper(Task.class));
    }

    public void insert(Task task) {
        jdbc.update(
                "insert into task (taskname, creationdate, statusid, personid) values(?,current_date, ?,?)",
                task.getTaskName(), task.getStatusId(), task.getPersonId());
    }

    public void update(Task task, int id) {
        jdbc.update(
                "update task set taskname = ?, updatedon = current_date where id = ?",
                task.getTaskName(), id);
    }
    public void delete(Task task, int id) {
        jdbc.update(
                "delete from task WHERE  id = ?", id);
    }


}

