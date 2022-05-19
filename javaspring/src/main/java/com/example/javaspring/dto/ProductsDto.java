package com.example.javaspring.dto;

import com.example.javaspring.model.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Component
public class ProductsDto {

    private long id;

    private String nameProduct;

    private long price;

    private String category;
}