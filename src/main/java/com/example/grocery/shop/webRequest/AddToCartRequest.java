package com.example.grocery.shop.webRequest;

import java.util.List;

import com.example.grocery.shop.model.Product;

public class AddToCartRequest {
   private String customerId;
   private List<Product> products;
public AddToCartRequest(String customerId, List<Product> products) {
    this.customerId = customerId;
    this.products = products;
}
public String getCustomerId() {
    return customerId;
}
public void setCustomerId(String customerId) {
    this.customerId = customerId;
}
public List<Product> getProducts() {
    return products;
}
public void setProducts(List<Product> products) {
    this.products = products;
}
   
}
