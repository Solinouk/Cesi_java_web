package cesi.java.projetWeb.repositories;

import cesi.java.projetWeb.Models.Person;
import cesi.java.projetWeb.Models.Status;
import cesi.java.projetWeb.Models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbc;

    public class TaskMapper implements RowMapper<Task> {
        ResultSet rs;

        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            Status status = new Status();
            Person person = new Person();

            task.setUpdatedOn(rs.getDate("updatedon"));
            task.setCreationDate(rs.getDate("creationDate"));
            task.setTaskName(rs.getString("taskname"));
            task.setId(rs.getInt("id"));

            status.setStatusName((rs.getString("statusname")));

            person.setName((rs.getString("name")));
            person.setAlias((rs.getString("alias")));

            task.setStatus(status);
            task.setPerson(person);
            return task;
        }
    }

    public List<Task> findAll() {

        String sql = "SELECT t.id, t.taskname, t.creationdate, t.updatedon, p.name, p.alias, s.statusname " +
                " FROM task t " +
                " left join status s on s.id = t.statusId" +
                " left join person p on t.personid = p.id";
        TaskMapper rowMapper = new TaskMapper();

        return jdbc.query(sql, rowMapper);
    }

    public Task findOne(int id) {

        String sql = "SELECT t.id, t.taskname, t.creationdate, t.updatedon, p.name, p.alias, s.statusname " +
                "FROM task t  left join status s on s.id = t.statusId left join person p on t.personid = p.id WHERE t.id =" +
                id;
        TaskMapper rowMapper = new TaskMapper();

        Task task = jdbc.queryForObject(
                sql, rowMapper);
        System.out.println(task);
        return task;
    }

    public void insert(Task task) {

        jdbc.update(
                "insert into task (taskname, creationdate, statusId, personid) values(?,current_date, ?,?)",
                task.getTaskName(),task.getStatus().getId(), task.getPerson().getId());
        System.out.println(task.getPerson().getId());
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

    public List<Task> getTasksByStatusId(int statusId) {

        String sql = "select * from task where statusId =" +
                statusId;

        return jdbc.query(sql,
                new BeanPropertyRowMapper<>(Task.class));
    }
}


