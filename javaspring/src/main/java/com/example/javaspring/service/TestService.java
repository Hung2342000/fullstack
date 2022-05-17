package com.example.javaspring.service;

import com.example.javaspring.model.Test;
import com.example.javaspring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public List<Test> getList(){
        return testRepository.findAll();
    }
}
