package com.example.pbl_api.controller;


import com.example.pbl_api.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RestController
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        return new ResponseEntity<>(categoryService.getAllCategories(), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategoriesName(){
        return new ResponseEntity<>(categoryService.getAllCategoriesName(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getOptionGroupsByCategory(@PathVariable(name = "id")int id){
        return new ResponseEntity<>(categoryService.getOpionGroupsByCategory(id), HttpStatus.OK);
    }


    @GetMapping("/group/{id}")
    public ResponseEntity<?> getAttributesByGroup(@PathVariable(name = "id")int id){
        return new ResponseEntity<>(categoryService.getAttributesByOptionGroup(id), HttpStatus.OK);
    }


}
