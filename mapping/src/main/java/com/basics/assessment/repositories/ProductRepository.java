package com.basics.assessment.repositories;

import com.basics.assessment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    // Product Repository
}
