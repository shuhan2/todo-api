package com.thoughtworks.restfulapi.restfulapi.controller;

import com.thoughtworks.restfulapi.restfulapi.model.Todo;
import com.thoughtworks.restfulapi.restfulapi.model.User;
import com.thoughtworks.restfulapi.restfulapi.repository.TodoRepository;
import com.thoughtworks.restfulapi.restfulapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @GetMapping
    public Page<Todo> getTodo(Pageable pageable){

        System.out.println(pageable);
        return todoRepository.findAll(pageable);
    }

    //        if (id > todoService.getTodoList().size()){
//            throw new Myexception();
//        }
    @GetMapping(value = "/{id}")
    public Todo getTodoById(@PathVariable(value = "id") long id){

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        return todoService.getTodoById(id);
    }

    @GetMapping(value = "/tag/{name}")
    public List<Todo> getTodoByTagName(@PathVariable(value = "name") String tagName){

//        if (id > todoService.getTodoList().size()){
//            throw new Myexception();
//        }
        return todoService.getTodoByTagName(tagName);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){

        return todoService.addTodo(todo);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTodo(@PathVariable(value = "id") Long id){
        todoService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Todo updateTodo(@PathVariable(value = "id") Long id,@RequestBody Todo todo ){
        return todoService.updateTodoById(id, todo);
    }

    @RequestMapping(value = "/page/{page}/size/{size}",method = RequestMethod.GET)
    public Page<Todo> getEntryByParams(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "size") Integer size){
        Pageable pageable = new PageRequest(page-1,size);
        Page<Todo> result = todoRepository.findAll(pageable);
        return result;
    }

//    private User getUserFromSessionId(HttpServletRequest request){
//        User user = Arrays.stream(request.get)
//    }

}
