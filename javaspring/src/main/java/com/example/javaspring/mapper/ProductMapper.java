package com.example.javaspring.mapper;

import com.example.javaspring.dto.ProductsDto;
import com.example.javaspring.model.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductsDto toProductsDto(Products products){
        ProductsDto productsDto = new ProductsDto();
        productsDto.setNameProduct(products.getNameProduct());
        productsDto.setPrice(products.getPrice());
        productsDto.setCategory(products.getCategory().getNameCategory());
        productsDto.setId(products.getId());
        return productsDto;
    }

    public Products toProduct(ProductsDto productsDto){
        Products products = new Products();
        products.setPrice(productsDto.getPrice());
        products.setNameProduct(productsDto.getNameProduct());
        return products;
    }
}
