package cesi.java.projetWeb.Models;

import java.util.Date;


public class Task {

    private int id;
    private String taskName;
    private Date creationDate;
    private Date updatedOn ;
    private int statusId;
    private int personId;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    private int RoleId;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Task() {

    }

    public Task(String taskName, Date creationDate, Date updatedOn) {
        this.taskName = taskName;
        this.creationDate = creationDate;
        this.updatedOn = updatedOn;
    }
}
