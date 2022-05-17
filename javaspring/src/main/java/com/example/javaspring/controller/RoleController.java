package com.example.javaspring.controller;

import com.example.javaspring.dto.RoleDto;
import com.example.javaspring.repository.PermissionReponsitory;
import com.example.javaspring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public List<RoleDto> getList(){
        List<RoleDto> roleDtos = roleService.getList();
        return roleDtos;
    }

    @PostMapping("/post")
    public void postRole(@RequestBody RoleDto roleDto){
        roleService.post(roleDto);
    }
}
