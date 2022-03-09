package com.example.grocery.shop.webResponse;

import com.example.grocery.shop.model.Cart;

public class AddToCartResponse {
    private String message;
    private Cart cart;
    public AddToCartResponse(String message, Cart cart) {
        this.message = message;
        this.cart = cart;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
