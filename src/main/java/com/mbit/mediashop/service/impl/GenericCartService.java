package com.mbit.mediashop.service.impl;

import com.mbit.mediashop.model.ShoppingCart;
import com.mbit.mediashop.model.CartItem;
import com.mbit.mediashop.model.Product;
import com.mbit.mediashop.service.CartService;
import com.mbit.mediashop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mbitiutskyi.
 */
@Service
public class GenericCartService implements CartService {

    private ShoppingCart shoppingCart;
    private ProductService productService;

    @Autowired
    public GenericCartService(ShoppingCart shoppingCart, ProductService productService) {
        this.shoppingCart = shoppingCart;
        this.productService = productService;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    @Override
    public void addProductById(int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            CartItem cartItem = new CartItem(product, 1, product.getPrice());
            shoppingCart.addCartItem(cartItem);
        }
    }

    @Override
    public void clearCart() {
        shoppingCart.clearItems();
    }

    @Override
    public void removeCartItemByProductId(int id) {
        shoppingCart.removeItemByProductId(id);
    }
}
