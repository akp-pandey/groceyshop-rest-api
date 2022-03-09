package com.example.grocery.shop.webRequest;

public class RemoveCartRequest {
    private String customerId;
    private String pId;
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getpId() {
        return pId;
    }
    public void setpId(String pId) {
        this.pId = pId;
    }
    public RemoveCartRequest(String customerId, String pId) {
        this.customerId = customerId;
        this.pId = pId;
    }

}
