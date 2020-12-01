package cesi.java.projetWeb.repositories;

import cesi.java.projetWeb.Models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbc;

    public List<Task> findAll() {

        String sql = "SELECT id, taskname, creationdate, updatedon, statusid, personid FROM task";
        List<Task> tasks = jdbc.query(
                sql,
                new BeanPropertyRowMapper(Task.class));
        return tasks;
    }

}

