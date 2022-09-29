package com.basics.responseEntity.services;

import com.basics.mapping.Models.Student;
import com.basics.responseEntity.models.Customer;
import com.basics.responseEntity.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //to save Customer
    public Customer saveCustomer(Customer c){
        return this.customerRepository.save(c);
    }

    //to get customer by id
    public Optional<Customer> getCustomer(Integer id){
        return this.customerRepository.findById(id);
    }

    //to get list of all customer
    public List<Customer> getAllCustomer(){
        return this.customerRepository.findAll();
    }

    //to delete Customer form database
    public void deleteCustomer(Integer id){
        this.customerRepository.deleteById(id);
    }

    //to update customer
    public Customer updateCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

}
