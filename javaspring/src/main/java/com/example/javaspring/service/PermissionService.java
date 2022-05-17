package com.example.javaspring.service;

import com.example.javaspring.dto.PermissionDto;
import com.example.javaspring.mapper.PermissionMapper;
import com.example.javaspring.model.Permission;
import com.example.javaspring.repository.PermissionReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionService {
    @Autowired
    PermissionReponsitory permissionReponsitory;

    @Autowired
    PermissionMapper permissionMapper;

    public List<PermissionDto> getList(){
        List<Permission> p = permissionReponsitory.findAll();
        List<PermissionDto> permissionDtos = new ArrayList<>();
        for (Permission permission : p){
            PermissionDto permissionDto = permissionMapper.toDto(permission);
            permissionDtos.add(permissionDto);
        }
        return permissionDtos;
    }
}
