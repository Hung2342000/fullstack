package com.example.javaspring.service;

import com.example.javaspring.dto.RoleDto;
import com.example.javaspring.mapper.RoleMapper;
import com.example.javaspring.model.Category;
import com.example.javaspring.model.Permission;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import com.example.javaspring.repository.PermissionReponsitory;
import com.example.javaspring.repository.RoleRepository;
import com.example.javaspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionReponsitory permissionReponsitory;

    public List<RoleDto> getList(){
        List<RoleDto> roleDtos = new ArrayList<>();
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles){
            RoleDto roleDto = roleMapper.toDto(role);
            roleDtos.add(roleDto);
        }
        return roleDtos;
    }

    public RoleDto post(RoleDto roleDto){
        Role rolepost = roleMapper.toRole(roleDto);
      /*  List<String> stringListUser = roleDto.getUsers();
        List<User> userList = new ArrayList<>();
        for(int i=0;i<stringListUser.size();i++){
            User user = userRepository.findByEmail(stringListUser.get(i));
            userList.add(user);
        }
        rolepost.setUsers(userList);*/
        List<String> stringListPermission = roleDto.getPermission();
        List<Permission> permissions = new ArrayList<>();
        for (int i=0;i<stringListPermission.size();i++){
            Permission permission = permissionReponsitory.findByName(stringListPermission.get(i));
            permissions.add(permission);
        }
        rolepost.setPermissions(permissions);
        roleRepository.save(rolepost);
        return roleDto;
    }

    public String deleteRole(long id){
        String test;
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            roleRepository.deleteById(id);
            test = "Xoá thành công";
        }
        else{
            test = "Không tồn tại bản ghi";
        }
        return test;
    }


}
