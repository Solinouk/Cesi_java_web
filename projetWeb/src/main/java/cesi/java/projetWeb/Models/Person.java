package cesi.java.projetWeb.Models;

public class Person {
    private int id;
    private String name;
    private String alias;
    private int roleId;

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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Person(){

    }

    public Person(String pName, String pAlias) {
        this.name = pName;
        this.alias = pAlias;
    }
}
