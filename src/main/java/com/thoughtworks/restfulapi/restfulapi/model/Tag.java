package com.thoughtworks.restfulapi.restfulapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private long id;
    private String name;

//    @ManyToMany(mappedBy = "tags")
//    private List<Todo> todos = new ArrayList<>();


    public Tag(String name) {
        this.name = name;
    }

    public Tag(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
