package com.development.cosmosdbapi.controller;

import com.development.cosmosdbapi.entity.Cart;
import com.development.cosmosdbapi.model.CartModel;
import com.development.cosmosdbapi.repository.CartRepository;
import com.development.cosmosdbapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class Controller {
    @Autowired
    private CartRepository repository;

    @Autowired
    private CartService cartService;

    @PostMapping("/{id}")
    public Cart pushCart(@RequestBody CartModel cartModel, @PathVariable String id) {
        return cartService.saveOrDeleteCart(cartModel, id, cartModel.getAction());
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable String id) {
        return cartService.getCart(id);
    }
}