package com.thoughtworks.restfulapi.restfulapi.service;

import com.thoughtworks.restfulapi.restfulapi.exp.Myexception;
import com.thoughtworks.restfulapi.restfulapi.model.Todo;
import com.thoughtworks.restfulapi.restfulapi.model.User;
import com.thoughtworks.restfulapi.restfulapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodoList(){
        return todoRepository.findAll();
    }

    public Todo getTodoById(long id){

        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Todo todo = todoRepository.findByUserIdAndId(user.getId(),id);
        if (todo != null){
            return todo;
        }
        else {
            throw  new Myexception();
        }
  }

    public Todo addTodo(Todo todo) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        todo.setUser(user);
        todoRepository.save(todo);
        return todo;
    }

    public void deleteById(long id) {
//        User user = TokenService.getPrincipal();
//        if(todoRepository.findByUserIdAndId(user.getId(),id)==null){
//            throw new Myexception();
//        }

        todoRepository.delete(id);
    }

    public Todo updateTodoById(Long id, Todo todo) {
        User user = TokenService.getPrincipal();
        Todo newTodo = todoRepository.findByUserIdAndId(user.getId(), id);
        if (newTodo == null){
            throw new Myexception();
        }
        todo.setId(id);
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodoByTagName(String tagName) {
        return todoRepository.findByTagsContains(tagName);
    }

//    public List<Todo> pageDivide(page,)
}
