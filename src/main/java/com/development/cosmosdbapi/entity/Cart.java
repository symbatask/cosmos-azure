package com.development.cosmosdbapi.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.*;

@Container(containerName = "cart")
public class Cart {
    @Id
    private String id;
    @PartitionKey
    private String userID;
    private List<Product> products;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public Cart(String userID, List<Product> products) {
        this.userID = userID;
        this.products = products;
    }

    public Cart(String userID, List<Product> products, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.userID = userID;
        this.products = products;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Cart(String id, String userID, List<Product> products, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.userID = userID;
        this.products = products;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Cart() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}