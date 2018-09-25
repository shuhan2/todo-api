package com.thoughtworks.restfulapi.restfulapi.repository;

import com.thoughtworks.restfulapi.restfulapi.model.Todo;
import com.thoughtworks.restfulapi.restfulapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByNameAndPassword(String name, String password);
}
