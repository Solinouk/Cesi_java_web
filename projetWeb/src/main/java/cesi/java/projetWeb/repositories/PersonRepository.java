package cesi.java.projetWeb.repositories;

import cesi.java.projetWeb.Models.Person;

import cesi.java.projetWeb.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepository {
    @Autowired
    JdbcTemplate jdbc;

    public class PersonMapper implements RowMapper<Person> {
        ResultSet rs;

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            Role role = new Role();

            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAlias(rs.getString("alias"));
            person.setCreationDate(rs.getDate("creationDate"));
            person.setUpdatedOn(rs.getDate("updatedOn"));

            role.setId(rs.getInt("id"));
            role.setRoleName(rs.getString("roleName"));

            person.setRole(role);
            return person;
        }
    }

    public List<Person> findAll() {

        String sql = "SELECT p.id, p.name, p.alias, r.roleName, p.creationdate, p.updatedon FROM person p JOIN role r ON p.roleId = r.id ORDER BY p.id";
        PersonMapper rowMapper = new PersonMapper();
        List<Person> persons = jdbc.query(sql, rowMapper);
        return persons;
    }

    public Person findOne(int id) {
        String sql = "SELECT p.id, p.name, p.alias, r.roleName, p.creationdate, p.updatedon FROM person p JOIN role r ON p.roleId = r.id WHERE p.id ="+id;
        PersonMapper rowMapper = new PersonMapper();
        return (Person) jdbc.queryForObject(
                sql,
                rowMapper);
    }

    public void insert(Person person) {
        jdbc.update(
                "insert into person (name, alias, creationdate, roleid) values(?,?,current_date,?)",
                person.getName(), person.getAlias(), person.getRole().getId());
    }

    public List<Person> getPersonByRoleId(int roleId) {
        String sql = "SELECT id, name, alias, creationdate, updatedon, roleid FROM person WHERE roleId ="+roleId;
        PersonMapper rowMapper = new PersonMapper();
        List<Person> persons = jdbc.query(
                sql,
                rowMapper);
        return persons;
    }

    public void update(Person person, int id) {
        jdbc.update(
                "update person set name = ?, alias = ?, roleid = ?, updatedon = current_date where id = ?",
                person.getName(), person.getAlias(), person.getRole().getId(), id);
    }

    public void delete(int id) {
        jdbc.update(
                "delete from person WHERE id = ?", id);
    }
}
