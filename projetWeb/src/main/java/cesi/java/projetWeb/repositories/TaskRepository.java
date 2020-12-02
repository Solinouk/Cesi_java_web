package cesi.java.projetWeb.repositories;

import cesi.java.projetWeb.Models.Task;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.*;
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

    public List<Task> findOne(int id) {
        String sql = "SELECT id, taskname, creationdate, updatedon, statusid, personid FROM task WHERE id = ?";

        List tasks = jdbc.query(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper(Task.class));
        return tasks;
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

    public void delete(int id) {
        jdbc.update(
                "delete from task WHERE  id = ?", id);
    }



    public class TaskMapper implements RowMapper<Task> {
        ResultSet rs;
        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            task.setStatusId(rs.getInt("statusId"));
            task.setUpdatedOn(rs.getDate("updatedon"));
            task.setCreationDate(rs.getDate("creationDate"));
            task.setTaskName(rs.getString("taskname"));
            task.setId(rs.getInt("id"));
            task.setPersonId(rs.getInt("personId"));

            return task;
        }
    }

    public List<Task> getTasksByStatusId ( int statusId){
        String sql = "select * from task where statusId = ?";
         List<Task> tasks = jdbc.query(sql,
                new Object[] { statusId },
                new TaskMapper());
         return tasks;
    }
  /*  public class getTasksByStatus (int statusId){
        List<Task> taskq = jdbc.query("select * from task where statusId = ?",
                new Object[] { statusId },

                new BeanPropertyRowMapper(Task.class));
    }*/

}

