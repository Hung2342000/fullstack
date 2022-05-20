package com.example.javaspring.controller;

import com.example.javaspring.dto.UserDto;
import com.example.javaspring.model.Permission;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import com.example.javaspring.repository.UserRepository;
import com.example.javaspring.security.jwt.JwtResponse;
import com.example.javaspring.security.jwt.JwtTokenProvider;
import com.example.javaspring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @PostMapping("login")
    public JwtResponse login(@RequestBody UserDto userDto){
        // Xac thuc tu username va password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(userDto);

        User user = userRepository.findByEmail(userDto.getUsername());
        List<Role> roles = user.getRoles();
        List<Permission> permissions = new ArrayList<>();
        for (int i =0 ;i<roles.size();i++){
            for (int j=0;j<roles.get(i).getPermissions().size();j++){
                permissions.add(roles.get(i).getPermissions().get(j));
            }
        }
        List<String> p = new ArrayList<>();
        for (Permission permission : permissions) {
            p.add(permission.getName());
        }

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setRoles(p);
        jwtResponse.setToken(jwt);
        return jwtResponse;
    }

}
