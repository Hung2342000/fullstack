package com.example.javaspring.controller;

import com.example.javaspring.dto.RoleDto;
import com.example.javaspring.repository.PermissionReponsitory;
import com.example.javaspring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    //@PreAuthorize("hasAuthority('list_role')")
    @GetMapping("/list")
    public List<RoleDto> getList(){
        List<RoleDto> roleDtos = roleService.getList();
        return roleDtos;
    }

    //@PreAuthorize("hasAuthority('add_role')")
    @PostMapping("/post")
    public void postRole(@RequestBody RoleDto roleDto){
        roleService.post(roleDto);
    }

    //@PreAuthorize("hasAuthority('delete_role')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        roleService.deleteRole( id) ;
    }
}
