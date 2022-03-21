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

    private String abc;

    // mappingDto
    public ProductsDto(long Id, String NameProduct, long Price, String NameCategory) {
        this.id = Id;
        this.nameProduct = NameProduct;
        this.category = NameCategory;
        this.price = Price;
    }

    // mapping2
    public ProductsDto(long Id, String NameProduct, long Price, String NameCategory, String abc) {
        this.id = Id;
        this.nameProduct = NameProduct;
        this.price = Price;
        this.category = NameCategory;
        this.abc = abc;
    }
}