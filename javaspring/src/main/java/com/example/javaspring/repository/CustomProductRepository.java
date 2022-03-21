package com.example.javaspring.repository;

import com.example.javaspring.dto.ProductsDto;
import com.example.javaspring.model.Products;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Service
public class CustomProductRepository {

    @PersistenceContext
    public EntityManager entityManager;

    public List<Products> findMaxPrice() {
        String sql = "SELECT p FROM Products p WHERE p.price = (SELECT MAX(price) FROM Products)";
        TypedQuery<Products> query = entityManager.createQuery(sql,Products.class);
        return query.getResultList();
    }
    public List<ProductsDto> find() {
        // cho nay a giu nguyen
        String sql = "SELECT p.id as id, p.name_product as nameProduct, p.price as price, p.category as category FROM Products p ORDER BY p.price ASC LIMIT 5";
        Query query = entityManager.createNativeQuery(sql,"mappingDto");
        return (List<ProductsDto>) query.getResultList();
    }

        public List<Products> findCategoryId(long id) {
        String sql = "SELECT * FROM Products Where name_category= ?1";
        Query query = entityManager.createNativeQuery(sql,Products.class);
        query.setParameter(1,id);
        return query.getResultList();
    }


}