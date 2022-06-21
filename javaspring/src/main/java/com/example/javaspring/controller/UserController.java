package com.example.javaspring.controller;


import com.example.javaspring.dto.UserDto;
import com.example.javaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('list_user')")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserDto> toList(){
        return userService.getList();
    }

    @PreAuthorize("hasAuthority('add_user')")
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public void post(@RequestBody UserDto userDto){
        userService.post(userDto);
    }

    @PreAuthorize("hasAuthority('delete_user')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        userService.deleteUser(id) ;
    }
}
