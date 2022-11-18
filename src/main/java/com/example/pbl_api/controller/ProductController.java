package com.example.pbl_api.controller;


import com.example.pbl_api.model.ProductModel;
import com.example.pbl_api.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getProducts(@RequestParam(name = "category",required = false) Integer idCategory,@RequestParam(name = "filter",required = false) List<Integer> filters){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        if(idCategory==null){
            return new ResponseEntity<>(productService.getAllProducts(), httpHeaders,HttpStatus.OK);
        }
        else if(idCategory!=null&&filters==null) {
            return new ResponseEntity<>(productService.getProductsByCategory(idCategory),httpHeaders, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(productService.getProductsByFilter(idCategory,filters),httpHeaders, HttpStatus.OK);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<?> addProducts(@RequestBody ProductModel product){
       ProductModel result= productService.saveProduct(product);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProducts(@RequestBody ProductModel product,@PathVariable(name = "id") long id){
        ProductModel result= productService.updateProduct(id,product);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProducts(@PathVariable(name = "id") long id){
        System.out.println("delete");
        ProductModel productDelete= productService.findProductModelById(id);
        if(productDelete==null) throw new RuntimeException();
        else {
            ProductModel result= productService.deleteProduct(productDelete.getId());
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProducts(@PathVariable(name = "id") long id){
        ProductModel product= productService.findProductModelById(id);
        if(product ==null) throw new RuntimeException();
        else return new ResponseEntity<>(product,HttpStatus.OK);
    }

}
