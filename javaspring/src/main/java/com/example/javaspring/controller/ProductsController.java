package com.example.javaspring.controller;

import com.example.javaspring.dto.ProductsDto;
import com.example.javaspring.model.Products;
import com.example.javaspring.repository.CustomProductRepository;
import com.example.javaspring.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @Autowired
    CustomProductRepository customProductRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ProductsDto> listProducts(){
        List<ProductsDto> productsDtoList = productsService.listProduct();
        return productsDtoList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductsDto getOne(@PathVariable long id){
        return productsService.getOne(id);
    }
    @RequestMapping(value = "/maxPrice", method = RequestMethod.GET)
    public List<ProductsDto> list1Products(){
        List<ProductsDto> productsDtoList = productsService.listMaxPrice();
        return productsDtoList;
    }
    @RequestMapping(value = "/listCategoryId/{id}", method = RequestMethod.GET)
    public List<ProductsDto> listCategory(@PathVariable long id){
        List<ProductsDto> List = productsService.listCategory(id);
        return List;
    }

    @RequestMapping(value = "/listProductDto", method = RequestMethod.GET)
    public List<ProductsDto> listCategory(){
        List<ProductsDto> List = customProductRepository.find() ;
        return List;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void productsPost(@RequestBody ProductsDto p){
      productsService.postProduct(p);

    }

    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public void productsPut(@RequestBody ProductsDto p, @PathVariable long id){
       productsService.puttProduct(p,id);

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void productsDelete(@PathVariable long id){
        productsService.deleleProducts(id);
    }

}
