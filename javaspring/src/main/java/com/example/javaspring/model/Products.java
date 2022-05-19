package com.example.javaspring.model;

import com.example.javaspring.dto.ProductsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "nameProduct",nullable = false)
    private String nameProduct;

    @Column(name = "price",nullable = false)
    private long price;

    @ManyToOne
    @JoinColumn(name = "category",nullable = false)
    private Category category;
}