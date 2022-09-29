package com.basics.responseEntity.controllers;

import com.basics.exceptionHandlers.CustomerNotFoundException;
import com.basics.responseEntity.models.Customer;
import com.basics.responseEntity.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/welcome")
    public ResponseEntity<String> greetings(){
        return ResponseEntity.ok("Welcome customer");
    }

    @GetMapping("/get")
    public ResponseEntity<Customer> test(){
        Customer c = new Customer();
        c.setId(1);
        c.setName("Suyash verma");
        c.setDepartment("Computer Science");
        return ResponseEntity.ok().body(c);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id){
//        Customer customer = this.customerService.getCustomer(id).get();
//        if(customer == null)
//            throw new CustomerNotFoundException("Customer Not found with id" + id);
//        return ResponseEntity.ok(customer);
        return ResponseEntity.ok(this.customerService.getCustomer(id).get());
    }

    @PostMapping("/post")
    public ResponseEntity<Customer> postCustomer(@Valid @RequestBody Customer c){
        return ResponseEntity.ok().body(this.customerService.saveCustomer(c));
    }
}
