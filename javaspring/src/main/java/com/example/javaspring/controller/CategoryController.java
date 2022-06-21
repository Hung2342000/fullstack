package com.example.javaspring.controller;

import com.example.javaspring.dto.CategoryDto;
import com.example.javaspring.service.CategoryService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PreAuthorize("hasAuthority('list_category')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CategoryDto> getList() {
        List<CategoryDto> categoryDtoList = categoryService.getList();
        return categoryDtoList;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CategoryDto findById(@PathVariable long id) {
        CategoryDto category = categoryService.getById(id);
        return category;
    }

    @PreAuthorize("hasAuthority('add_category')")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void postCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.postCategory(categoryDto);
    }

    @PreAuthorize("hasAuthority('edit_category')")
    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public void putCategory(@RequestBody CategoryDto categoryDto, @PathVariable long id) {
        categoryService.putCategory(categoryDto, id);
    }

    @PreAuthorize("hasAuthority('delete_category')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/report/{format}")
    public String exportReport(@PathVariable("format") String format) throws JRException, IOException {
        String downloadUri = categoryService.exportReport(format);
        return downloadUri;
    }

}
