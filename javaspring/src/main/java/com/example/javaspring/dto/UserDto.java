package com.example.javaspring.dto;
import com.example.javaspring.model.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
@Component
public class UserDto {
    private Long id ;
    private String name;
    private String username;
    private String password;
    private List<String> roles;
}
