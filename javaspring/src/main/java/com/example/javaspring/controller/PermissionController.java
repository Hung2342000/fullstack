package com.example.javaspring.controller;

import com.example.javaspring.dto.PermissionDto;
import com.example.javaspring.model.Permission;
import com.example.javaspring.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PermissionDto> list(){
        return permissionService.getList();
    }
}
