package com.example.grocery.shop.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class Cart {
    @Id
    private String id;
    private String customerId;
    private String adminId;
    private List<Product> cartItem;
    public Cart(String id, String customerId, String adminId, List<Product> cartItem) {
        this.id = id;
        this.customerId = customerId;
        this.adminId = adminId;
        this.cartItem = cartItem;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
   
   
    public Cart(String customerId, List<Product> cartItem) {
        this.customerId = customerId;
        this.cartItem = cartItem;
    }
    public String getCustomerId() {
        return customerId;
    }
    public String getId() {
        return id;
    }
    public Cart(String id, String customerId, List<Product> cartItem) {
        this.id = id;
        this.customerId = customerId;
        this.cartItem = cartItem;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public List<Product> getCartItem() {
        return cartItem;
    }
    public void setCartItem(List<Product> cartItem) {
        this.cartItem = cartItem;
    }
    

}
