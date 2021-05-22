package com.development.cosmosdbapi.model;

import com.development.cosmosdbapi.entity.Cart;
import com.development.cosmosdbapi.entity.Product;

public class CartModel {
    private String action;
    private Product product;

    public CartModel(String action, Product product) {
        this.action = action;
        this.product = product;
    }

    public CartModel() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
