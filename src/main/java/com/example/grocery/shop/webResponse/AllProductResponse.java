package com.example.grocery.shop.webResponse;

import java.util.ArrayList;
import java.util.List;

import com.example.grocery.shop.model.Product;

public class AllProductResponse {
    private String message;
    private List<Product> allProduct;
    public AllProductResponse(String message, List<Product> allProduct) {
        this.message = message;
        this.allProduct = allProduct;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Product> getAllProduct() {
        return allProduct;
    }
    public void setAllProduct(ArrayList<Product> allProduct) {
        this.allProduct = allProduct;
    }
    
}
