package com.basics.assessment.controllers;

import com.basics.assessment.models.Product;
import com.basics.assessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/welcome")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Welcome to Product API");
    }

    @GetMapping("/get")
    public  ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(this.productService.getAllProduct());
    }

    @GetMapping("/get/{id}")
    public  ResponseEntity<Product> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok(this.productService.getProductById(id).get());
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.addProduct(product));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id,@RequestBody Product product){
        product.setProduct_id(id);
        return ResponseEntity.ok().body(this.productService.addProduct(product));
    }
}
