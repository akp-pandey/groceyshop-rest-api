package com.example.grocery.shop.controller;

import com.example.grocery.shop.model.Customer;
import com.example.grocery.shop.repository.CustomerRepository;
import com.example.grocery.shop.webRequest.LoginRequest;
import com.example.grocery.shop.webResponse.CustomerResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class HomeController {

    @Autowired
    CustomerRepository cRepository;

    @PostMapping("/register")
    public CustomerResponse registerCustomer(@RequestBody Customer customer){
         CustomerResponse cr=cRepository.findByEmail(customer.getEmail());
         System.out.println("Object is"+cRepository.findByEmail(customer.getEmail()));
         if(cr==null){
             cRepository.save(customer);
             return new CustomerResponse("User registered sucessfully", customer);
         }else{
             return new CustomerResponse("User already exist ! Please try with other email", customer);
         }
    
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PostMapping("/login")
    public CustomerResponse loginCustomer(@RequestBody LoginRequest loginRequest){
        Customer cr=cRepository.findByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword());
        if(cr!=null){
                return new CustomerResponse("Login successfull",cr);
        }else{
            return new CustomerResponse("Wrong credentials ! Please try again", null);
        }
    }
}
