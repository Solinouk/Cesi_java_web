package cesi.java.projetWeb.repositories;

import cesi.java.projetWeb.Models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @Autowired
    JdbcTemplate jdbc;

    public List<Person> findAll() {

        String sql = "SELECT id, name, alias, creationdate, updatedon, roleid FROM person";
        List<Person> persons = jdbc.query(
                sql,
                new BeanPropertyRowMapper(Person.class));
        return persons;
    }

    public Person findOne(int id) {
        String sql = "SELECT id, name, alias, creationdate, updatedon, roleid, FROM person WHERE id = ?";

        return (Person) jdbc.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper(Person.class));
    }

    public void insert(Person person) {
        jdbc.update(
                "insert into person (name, alias, creationdate, roleid) values(?,?,current_date,?)",
                person.getName(), person.getAlias(), person.getRoleId());
    }
}
