package com.example.javaspring.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
@Component
public class PermissionDto {
    private long id;
    private String name;
}
