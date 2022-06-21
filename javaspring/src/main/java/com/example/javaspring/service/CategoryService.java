package com.example.javaspring.service;

import com.example.javaspring.dto.CategoryDto;
import com.example.javaspring.mapper.CategoryMapper;
import com.example.javaspring.model.Category;
import com.example.javaspring.repository.CategoryRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public List<CategoryDto> getList(){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for ( Category category : categoryList){
            CategoryDto categoryDto = categoryMapper.toCategoryDto(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
    public CategoryDto getById(long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            CategoryDto dto = categoryMapper.toCategoryDto(category.get());
            return dto;
        }
        else {
            throw new RuntimeException("Không tồn tại bản ghi " + id);
        }
    }

    public String postCategory(CategoryDto categoryDto){
        Category category = categoryRepository.findByName(categoryDto.getNameCategory());
        String test;
        if(category != null){
            test = "Đã tồn tại bản ghi";
        }
        else {
            Category post = categoryMapper.toCategory(categoryDto);
            categoryRepository.save(post);
            test ="Thêm thành công";
        }
        return test;
    }

    public String putCategory(CategoryDto categoryDto,long id){
        String test;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            Category category = categoryRepository.findByName(categoryDto.getNameCategory());
            if(category != null){
                test = "Đã tồn tại bản ghi";
            }
            else{
                Category categoryPut = categoryOptional.get();
                categoryPut.setNameCategory(categoryDto.getNameCategory());
                categoryRepository.save(categoryPut);
                test = "Sửa thành công";
            }

        }
        else{
            test = "Không tồn tại bản ghi";
        }
        return test;
    }

    public String deleteCategory(long id){
        String test;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            categoryRepository.deleteById(id);
            test = "Xoá thành công";
        }
        else{
            test = "Không tồn tại bản ghi";
        }
        return test;
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "\\Users\\hung\\web";
        List<Category> categoryList = categoryRepository.findAll();
        File file = ResourceUtils.getFile("classpath:category.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(categoryList);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("createBy", "hungPT");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {

            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\category.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\category.pdf");
        }
        return path;
    }

}
