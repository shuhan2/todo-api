package com.thoughtworks.restfulapi.restfulapi.repository;

import com.thoughtworks.restfulapi.restfulapi.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
//        List<Todo> findByNameContains(String name);   //todo:查找关键词
//    Page<Todo> findAll(Pageable pageable);
    List<Todo> findByTagsContains(String tagName);

    Todo findByUserIdAndId(long userId, long id);
    List<Todo> findByName(String test);

//    void deleteByUserIdAndId(long id);
}
