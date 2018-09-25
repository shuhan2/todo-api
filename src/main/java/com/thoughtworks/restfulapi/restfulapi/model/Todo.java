package com.thoughtworks.restfulapi.restfulapi.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Todo{

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String status;
    private Date date;

    public Todo(long id, String name, String status, Date date) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.date = date;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "todo_tag",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Date getDueDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(Date dueDate) {
        this.date = dueDate;
    }

    public Todo(){

    }

}
