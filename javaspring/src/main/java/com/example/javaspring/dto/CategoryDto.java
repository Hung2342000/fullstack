package com.example.javaspring.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
@Component
public class CategoryDto {

    private long id;
    private String nameCategory;

}