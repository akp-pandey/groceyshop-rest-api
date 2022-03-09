package com.example.grocery.shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productDb")
public class Product {
    @Id
    private String id;
    private String adminId;
    private String pName;
    private Integer pPrice;
    private String pDescription;
    private Integer pRating;
    public Product(String adminId, String pName, Integer pPrice, String pDescription, Integer pRating) {
        this.adminId = adminId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
        this.pRating = pRating;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public Integer getPPrice() {
        return pPrice;
    }
    public void setPPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }
    public String getpDescription() {
        return pDescription;
    }
    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }
    public Integer getpRating() {
        return pRating;
    }
    public void setpRating(Integer pRating) {
        this.pRating = pRating;
    }
  
}
