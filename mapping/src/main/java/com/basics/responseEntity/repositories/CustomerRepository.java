package com.basics.responseEntity.repositories;

import com.basics.responseEntity.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
