package com.example.javaspring.mapper;


import com.example.javaspring.dto.UserDto;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public UserDto toDto(User user){
        UserDto userdto = new UserDto();
        userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        List<String> role = new ArrayList<>();
        List<Role> list = user.getRoles();
        for (int i=0;i<list.size();i++){
            role.add(list.get(i).getName());
        }
        userdto.setRoles(role);
        return userdto;
    }

    public User toUser(UserDto userdto){
        User user = new User();
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        return user;
    }

}
