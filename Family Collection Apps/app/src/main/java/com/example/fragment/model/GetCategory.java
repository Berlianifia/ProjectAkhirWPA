package com.example.fragment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCategory {
    String status;
    @SerializedName("result")
    List<Product> productList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
