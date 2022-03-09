package com.example.grocery.shop.repository;

import com.example.grocery.shop.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{id:?0}")
    Product findByProductId(String id);
}
