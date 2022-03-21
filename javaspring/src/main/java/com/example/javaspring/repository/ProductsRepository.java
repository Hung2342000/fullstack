package com.example.javaspring.repository;

import com.example.javaspring.dto.ProductsDto;
import com.example.javaspring.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository

public interface ProductsRepository extends JpaRepository<Products,Long> {
    @Query("select p from Products p where p.nameProduct = ?1")
    Products findByName(String name);
}
