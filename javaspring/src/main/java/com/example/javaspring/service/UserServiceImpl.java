package com.example.javaspring.service;
import com.example.javaspring.model.Permission;
import com.example.javaspring.model.Role;
import com.example.javaspring.model.User;
import com.example.javaspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            List<Role> roles = user.getRoles();
            List<Permission> permissions = new ArrayList<>();
            for (int i =0 ;i<roles.size();i++){
                for (int j=0;j<roles.get(i).getPermissions().size();j++){
                    permissions.add(roles.get(i).getPermissions().get(j));
                }
            }
            List<String> stringList = new ArrayList<>();
            for (Permission permission : permissions) {
                stringList.add(permission.getName());
            }

            for (String s:stringList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(s);
                grantedAuthorities.add(authority);
            }



            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("Không tồn tại");
        }
    }
}
