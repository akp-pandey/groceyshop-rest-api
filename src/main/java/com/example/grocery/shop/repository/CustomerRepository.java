package com.example.grocery.shop.repository;

import com.example.grocery.shop.model.Customer;
import com.example.grocery.shop.model.Product;
import com.example.grocery.shop.webResponse.CustomerResponse;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer,String> {

    @Query("{email:?0}")
    public CustomerResponse findByEmail(String email);

    @Query("{email:?0,password:?1}")
    public Customer findByEmailAndPassword(String email,String password);

}
