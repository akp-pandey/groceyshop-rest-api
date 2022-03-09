package com.example.grocery.shop.webResponse;

import com.example.grocery.shop.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponse {
    private String message;
    private Customer customer;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public CustomerResponse(String message, Customer customer) {
        this.message = message;
        this.customer = customer;
    }
    
}
