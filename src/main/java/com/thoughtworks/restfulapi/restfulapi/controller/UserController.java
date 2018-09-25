package com.thoughtworks.restfulapi.restfulapi.controller;

import com.thoughtworks.restfulapi.restfulapi.exp.Myexception;
import com.thoughtworks.restfulapi.restfulapi.model.Todo;
import com.thoughtworks.restfulapi.restfulapi.model.User;
import com.thoughtworks.restfulapi.restfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/registation")
    public void register(@RequestBody User user) {
         userService.isSucceed(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        if(userService.isLogin(user)=="")
        {
            throw new Myexception();
        }
        else
        {
            return ResponseEntity.ok().header("sessionId",userService.isLogin(user)).build();

        }
    }
}
