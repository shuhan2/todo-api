package com.thoughtworks.restfulapi.restfulapi.service;

import com.thoughtworks.restfulapi.restfulapi.exp.Myexception;
import com.thoughtworks.restfulapi.restfulapi.model.User;
import com.thoughtworks.restfulapi.restfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    public void isSucceed(User user) {
        if (userRepository.findByName(user.getName())!=null)
            throw new Myexception();
        else
            userRepository.save(user);
    }

    public String isLogin(User user) {
        User newUser = userRepository.findByNameAndPassword(user.getName(),user.getPassword());
        if (newUser != null) {
            Long id = newUser.getId();
            String sessionId = tokenService.generateSession(id.toString());
            return sessionId;
        }
        else
            return "";
    }
}
