package com.example.javaspring.repository;

import com.example.javaspring.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionReponsitory extends JpaRepository<Permission,Long> {
    @Query("select a  from Permission a where a.name =?1")
    Permission findByName(String name);
}
