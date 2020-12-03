package cesi.java.projetWeb.Models;

import java.io.Serializable;
import java.util.Date;


public class Task  implements Serializable {

    private int id;
    private String taskName;
    private Date creationDate;
    private Date updatedOn ;
    private int statusId;
    private int personId;

    public Task() {
    }

    public Task(int id, String taskName, Date creationDate, Date updatedOn, int statusId, int personId) {
        this.id = id;
        this.taskName = taskName;
        this.creationDate = creationDate;
        this.updatedOn = updatedOn;
        this.statusId = statusId;
        this.personId = personId;
    }

    public Task(int id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
