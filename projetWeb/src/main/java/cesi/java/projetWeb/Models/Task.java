package cesi.java.projetWeb.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Task  implements Serializable {

    private int id;
    private String taskName;
    private Date creationDate;
    private Date updatedOn ;
    /*private int statusId;
    private int personId;*/
    private Status status;
    private Person person;

    public Task() {
    }

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(int id, String taskName, Date creationDate, Status status, Person person) {
        this.id = id;
        this.taskName = taskName;
        this.creationDate = new Date();
        this.status = status;
        this.person = person;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", creationDate=" + creationDate +
                ", updatedOn=" + updatedOn +
                ", status=" + status +
                ", person=" + person +
                '}';
    }
}

