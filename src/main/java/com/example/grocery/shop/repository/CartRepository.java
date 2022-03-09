package com.example.grocery.shop.repository;

import com.example.grocery.shop.model.Cart;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart,String> {
    
}
