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
        String sql = "SELECT id, name, alias, creationdate, updatedon, roleid FROM person WHERE id = ?";

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

    public List<Person> getPersonByRoleId(int roleId) {
        String sql = "SELECT id, name, alias, creationdate, updatedon, roleid FROM person WHERE roleId = ?";
        List<Person> persons = jdbc.query(
                sql,
                new Object[]{roleId},
                new BeanPropertyRowMapper(Person.class));
        return persons;
    }

    public void update(Person person, int id) {
        jdbc.update(
                "update person set name = ?, alias = ?, roleid = ?, updatedon = current_date where id = ?",
                person.getName(), person.getAlias(), person.getRoleId(), id);
    }

    public void delete(int id) {
        jdbc.update(
                "delete from person WHERE id = ?", id);
    }
}
