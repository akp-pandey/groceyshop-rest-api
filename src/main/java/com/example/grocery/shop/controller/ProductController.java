package com.example.grocery.shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.grocery.shop.model.Cart;
import com.example.grocery.shop.model.Customer;
import com.example.grocery.shop.model.Product;
import com.example.grocery.shop.repository.CartRepository;
import com.example.grocery.shop.repository.CustomerRepository;
import com.example.grocery.shop.repository.ProductRepository;
import com.example.grocery.shop.webRequest.AddToCartRequest;
import com.example.grocery.shop.webRequest.RemoveCartRequest;
import com.example.grocery.shop.webResponse.AddToCartResponse;
import com.example.grocery.shop.webResponse.AllProductResponse;
import com.example.grocery.shop.webResponse.ProductResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/admin")
public class ProductController {
    
    @Autowired
    ProductRepository pRepository;

    @Autowired 
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/addProduct")
    public ProductResponse addProduct(@RequestBody Product product){
        pRepository.save(product);
        return new ProductResponse("Product added successfully", product);
    }
    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping("/getAllProduct")
    public AllProductResponse getAllProduct(){
        List<Product> pList=pRepository.findAll();
        return new AllProductResponse("Product fetched successfully",pList);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PostMapping("/addToCart")
    public AddToCartResponse addToCart(@RequestBody AddToCartRequest addToCartRequest){
        int totalPrice=0;
        Optional<Customer> customer=customerRepository.findById(addToCartRequest.getCustomerId());
        if(customer.isPresent()){
            List<Product> alreadyCartItems=customer.get().getCustomerCart();
            alreadyCartItems.addAll(addToCartRequest.getProducts());
            for(int i=0;i<alreadyCartItems.size();i++){
                totalPrice+=alreadyCartItems.get(i).getPPrice();
            }
            Customer customer2=customer.get();
            customer2.setCustomerCart(alreadyCartItems);
            customer2.setTotalPriceInCart(totalPrice);
            customerRepository.save(customer2);
            return new AddToCartResponse("product added to cart successfully",null);
        }else{
            return new AddToCartResponse("no customer exists !!", null);
        }

    }

    @PostMapping("/removeFromCart")
    public ResponseEntity<AddToCartResponse> removeFromCart(@RequestBody RemoveCartRequest removeCartRequest){
        List<Product> newProductsList=new ArrayList<Product>();
        int amount=0;
        Optional<Customer> customer=customerRepository.findById(removeCartRequest.getCustomerId());
        if(customer.isPresent()){
            List<Product> productsList=customer.get().getCustomerCart();
            System.out.println("Removing from cart");
            for(int i=0;i<productsList.size();i++){
                if(!removeCartRequest.getpId().equals(productsList.get(i).getId())){
                    newProductsList.add(productsList.get(i));
                }
                if(removeCartRequest.getpId().equals(productsList.get(i).getId())){
                    amount=productsList.get(i).getPPrice();
                }
            }
        Customer customer2=customer.get();
        customer2.setTotalPriceInCart(customer.get().getTotalPriceInCart()-amount);
        customer2.setCustomerCart(newProductsList);
        customerRepository.save(customer2);
        return new ResponseEntity<AddToCartResponse>(new AddToCartResponse("product remove from cart ", null),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllCustomer")
    public List<Customer>  getAllCartItem(){
        return customerRepository.findAll();
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody AddToCartRequest addToCartRequest){
        int orderAmount=0;
        Optional<Customer> customer=customerRepository.findById(addToCartRequest.getCustomerId());
        Customer customer2=customer.get();
        customer2.setCustomerOrder(addToCartRequest.getProducts());
        for(int i=0;i<addToCartRequest.getProducts().size();i++){
           if(!(customer2.getCustomerCart().contains(addToCartRequest.getProducts().get(i)))){
               removeFromCart(new RemoveCartRequest(addToCartRequest.getCustomerId(), addToCartRequest.getProducts().get(i).getId()));
           }
        }
        for(int i=0;i<customer2.getCustomerOrder().size();i++){
            orderAmount+=customer2.getCustomerOrder().get(i).getPPrice();
        }
        customer2.setTotalOrderCost(orderAmount);
        customerRepository.save(customer2);

        return new ResponseEntity<>("Order Placed Successfully",HttpStatus.ACCEPTED);



    }
}
