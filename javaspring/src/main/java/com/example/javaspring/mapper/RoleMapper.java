package com.example.javaspring.mapper;

import com.example.javaspring.dto.RoleDto;
import com.example.javaspring.model.Permission;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {
    public RoleDto toDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());

   /*     List<String> user = new ArrayList<>();
        List<User> list = role.getUsers();
        for (int i = 0; i < list.size(); i++) {
            user.add(list.get(i).getName());
        }
        roleDto.setUsers(user);*/

        List<String> permission = new ArrayList<>();
        List<Permission> listPermission = role.getPermissions();
        for (int i = 0; i < listPermission.size(); i++) {
            permission.add(listPermission.get(i).getName());
        }
        roleDto.setPermission(permission);
        return roleDto;
    }

    public Role toRole(RoleDto roleDto){
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }
}
