package com.example.javaspring.mapper;

import com.example.javaspring.dto.PermissionDto;
import com.example.javaspring.model.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {
    public PermissionDto toDto(Permission permission){
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setId(permission.getId());
        permissionDto.setName(permission.getName());
        return permissionDto;
    }

}
