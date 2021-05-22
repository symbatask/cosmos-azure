package com.development.cosmosdbapi.service;

import com.azure.cosmos.models.PartitionKey;
import com.development.cosmosdbapi.entity.Cart;
import com.development.cosmosdbapi.entity.Product;
import com.development.cosmosdbapi.model.CartModel;
import com.development.cosmosdbapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository repository;

    @Override
    public Cart getCart(String userId) {
        Flux<Cart> byUserID = repository.findByUserID(userId);
        List<Cart> block = byUserID.collectList().block();
        if (block.size() != 0) {
            return block.get(0);
        }
        return null;
    }

    @Override
    public Cart saveOrDeleteCart(CartModel cartModel, String userId, String action) {
        switch (action) {
            case "add" : {
                return addCart(cartModel, userId);
            }
            case "delete" : {
                return deleteFromCart(cartModel, userId);
            }
        }
        return null;
    }

    private Cart addCart(CartModel cartModel, String userId) {
        Cart cartByUser = getCart(userId);
        if (cartByUser == null) {
            Cart cart = new Cart();
            List<Product> productsList = new LinkedList<>();
            productsList.add(cartModel.getProduct());
            cart.setId(System.currentTimeMillis() + "");
            cart.setProducts(productsList);
            cart.setUserID(userId);
            cart.setDateCreated(LocalDateTime.now());
            cart.setDateUpdated(LocalDateTime.now());
            add(cart);
            return cart;
        } else {
            repository.deleteById(cartByUser.getId(), new PartitionKey(cartByUser.getUserID()));
            List<Product> products = cartByUser.getProducts();
            boolean isConsist = false;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getChipset().equals(cartModel.getProduct().getChipset())){
                    products.get(i).setCount(products.get(i).getCount() + cartModel.getProduct().getCount());
                    isConsist = true;
                }
            }
            if (!isConsist) {
                products.add(cartModel.getProduct());
            }
            cartByUser.setProducts(products);
            cartByUser.setDateUpdated(LocalDateTime.now());
            add(cartByUser);
            return cartByUser;
        }
    }

    private Cart deleteFromCart(CartModel cartModel, String userId) {
        Cart cartByUser = getCart(userId);
        if (cartByUser == null){
            return null;
        } else {
            repository.deleteById(cartByUser.getId(), new PartitionKey(cartByUser.getUserID()));
            List<Product> products = cartByUser.getProducts();
            for (int i = 0; i < products.size(); i++){
                if (products.get(i).getChipset().equals(cartModel.getProduct().getChipset())){
                    if (products.get(i).getCount() <= cartModel.getProduct().getCount()) {
                        products.remove(products.get(i));
                    } else {
                        products.get(i).setCount(products.get(i).getCount() - cartModel.getProduct().getCount());
                    }
                }
            }
            cartByUser.setProducts(products);
            cartByUser.setDateUpdated(LocalDateTime.now());
            add(cartByUser);
            return cartByUser;
        }
    }

    private void add(Cart cart) {
        final Cart testProduct = cart;
        final Mono<Cart> saveUserMono = repository.save(testProduct);
    }
}
