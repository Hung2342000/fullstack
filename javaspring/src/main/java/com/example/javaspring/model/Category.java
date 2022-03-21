package com.example.javaspring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "nameCategory", nullable = false,unique = true)
    private String nameCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL )
    private List<Products> products;
}