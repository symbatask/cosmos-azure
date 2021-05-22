package com.development.cosmosdbapi.service;

import com.development.cosmosdbapi.entity.Cart;
import com.development.cosmosdbapi.model.CartModel;

public interface CartService {
    Cart getCart(String userId);
    Cart saveOrDeleteCart(CartModel cartModel, String userId, String action);
}
