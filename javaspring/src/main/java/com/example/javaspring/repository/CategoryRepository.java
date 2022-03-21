package com.example.javaspring.repository;

import com.example.javaspring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    @Query("select c from Category c where c.nameCategory = ?1")
    Category findByName(String name);
}
