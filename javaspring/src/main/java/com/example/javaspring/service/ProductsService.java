package com.example.javaspring.service;

import com.example.javaspring.dto.ProductsDto;
import com.example.javaspring.mapper.ProductMapper;
import com.example.javaspring.model.Category;
import com.example.javaspring.model.Products;
import com.example.javaspring.repository.CategoryRepository;
import com.example.javaspring.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductMapper productMapper;


    public List<ProductsDto> listProduct(){
        List<Products> productsList = productsRepository.findAll();
        List<ProductsDto> productsDtoList = new ArrayList<>();
        for (Products products : productsList){
            productsDtoList.add(productMapper.toProductsDto(products));
        }
        return productsDtoList;
    }

    public ProductsDto getOne(long Id){
        Optional<Products> product = productsRepository.findById(Id);

        if(product.isPresent()){
            return productMapper.toProductsDto(product.get());
        }
        else {
            throw new RuntimeException("Không tồn tại bản ghi " + Id);
        }


    }

    public String postProduct(ProductsDto productsDto){
        Products products = productsRepository.findByName(productsDto.getNameProduct());
        String test;
        if(products != null){
            test = "Đã tồn tại";
        }
        else{
            if(categoryRepository.findByName(productsDto.getCategory())!= null){
                Products productPost = productMapper.toProduct(productsDto);
                Category category = categoryRepository.findByName(productsDto.getCategory());
                productPost.setCategory(category);
                productsRepository.save(productPost);
                test = "Thêm thành công";
            }
            else{
                test = "Không tồn tại Category";
            }

        }
        return test;

    }
    public String putProduct(ProductsDto productsDto, long id){
        Optional<Products> productsOptional = productsRepository.findById(id);
        String test;
        if(productsOptional.isPresent() && categoryRepository.findByName(productsDto.getCategory())!= null){
            Products productPut = productsOptional.get();
            Category category = categoryRepository.findByName(productsDto.getCategory());
            productPut.setNameProduct(productsDto.getNameProduct());
            productPut.setPrice(productsDto.getPrice());
            productPut.setCategory(category);
            productsRepository.save(productPut);
            test = "Sửa thành công";
        }
        else{
            test = "Không tồn tại Category";
        }
        return test;
    }

    public String deleleProducts(long id){
        Optional<Products> productsOptional = productsRepository.findById(id);
        String test;
        if(productsOptional.isPresent()){
          productsRepository.deleteById(id);
          test = "Xoá thành công";
        }
        else{

            test = "Không tôn tại bản ghi";
        }
        return test;
    }

}
