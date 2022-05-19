package com.example.javaspring.mapper;


import com.example.javaspring.dto.UserDto;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserDto toDto(User user){
        UserDto userdto = new UserDto();
        userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setUsername(user.getUsername());
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
        user.setUsername(userdto.getUsername());
        String password = passwordEncoder.encode(userdto.getPassword());
        user.setPassword(password);
        return user;
    }

}
