package com.example.javaspring.controller;

import com.example.javaspring.model.Test;
import com.example.javaspring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/list")
    public List<Test> getList(){
        return testService.getList();
    }


}
