package cesi.java.projetWeb.Models;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private String alias;
    private Date creationDate;
    private Date updatedOn;
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Person(){

    }

    public Person(String pName, String pAlias, Role pRole) {
        this.name = pName;
        this.alias = pAlias;
        this.role = pRole;
    }

    public Person(int id, String name, String alias, Date creationDate, Date updatedOn, Role role) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.creationDate = creationDate;
        this.updatedOn = updatedOn;
        this.role = role;
    }
}
