package com.example.javaspring.service;

import com.example.javaspring.dto.UserDto;
import com.example.javaspring.mapper.UserMapper;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import com.example.javaspring.repository.RoleRepository;
import com.example.javaspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleRepository roleRepository;

    public List<UserDto> getList(){
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for ( User user : list){
            UserDto userDto = userMapper.toDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto post(UserDto userDto){
        List<String> stringList = userDto.getRoles();
        User userpost = userMapper.toUser(userDto);
        List<Role> roleList = new ArrayList<>();
        for (int i=0;i < stringList.size();i++){
            Role role = roleRepository.findByName(stringList.get(i));
            roleList.add(role);
        }
        userpost.setRoles(roleList);
        userRepository.save(userpost);
        return userDto;
    }

}
