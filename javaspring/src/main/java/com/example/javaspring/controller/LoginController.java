package com.example.javaspring.controller;

import com.example.javaspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public String login(){
        return "okii";
    }
}
