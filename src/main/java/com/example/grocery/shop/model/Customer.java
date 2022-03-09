package com.example.grocery.shop.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "customer")
@Data
@AllArgsConstructor
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String address;
    private String password;
    private List<Product> customerCart;
    private List<Product> customerOrder;
    private Integer totalPriceInCart=0;
    private Integer totalOrderCost=0;
    public Customer(String firstName, String lastName, String contact, String email, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    public Customer(String id, String firstName, String lastName, String contact, String email, String address,
            String password, List<Product> customerCart, Integer totalPriceInCart) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
        this.customerCart = customerCart;
        this.totalPriceInCart = totalPriceInCart;
    }
    public Customer(String id, String firstName, String lastName, String contact, String email, String address,
            String password, List<Product> customerCart, List<Product> customerOrder, Integer totalPriceInCart,
            Integer totalOrderCost) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
        this.customerCart = customerCart;
        this.customerOrder = customerOrder;
        this.totalPriceInCart = totalPriceInCart;
        this.totalOrderCost = totalOrderCost;
    }
    public List<Product> getCustomerOrder() {
        return customerOrder;
    }
    public void setCustomerOrder(List<Product> customerOrder) {
        this.customerOrder = customerOrder;
    }
    public Integer getTotalOrderCost() {
        return totalOrderCost;
    }
    public void setTotalOrderCost(Integer totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }
    public Customer() {
    }
    public List<Product> getCustomerCart() {
        return customerCart;
    }
    public void setCustomerCart(List<Product> customerCart) {
        this.customerCart = customerCart;
    }
    public Integer getTotalPriceInCart() {
        return totalPriceInCart;
    }
    public void setTotalPriceInCart(Integer totalPriceInCart) {
        this.totalPriceInCart = totalPriceInCart;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
