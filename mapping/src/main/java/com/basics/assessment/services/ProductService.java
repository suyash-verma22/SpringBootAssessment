package com.basics.assessment.services;

import com.basics.assessment.models.Product;
import com.basics.assessment.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product){
        return this.productRepository.save(product);
    }

    public List<Product> addProductList(List<Product> products){
        return this.productRepository.saveAll(products);
    }

    public Optional<Product> getProductById(Integer id){
        return this.productRepository.findById(id);
    }

    public List<Product> getAllProduct(){
        return this.productRepository.findAll();
    }

    public void deleteProduct(Integer id){
        this.productRepository.deleteById(id);
    }
}
