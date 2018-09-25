package com.thoughtworks.restfulapi.restfulapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String password;

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<Todo> todos = new ArrayList<>();


    public User() {
    }

    public User(int id,String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
