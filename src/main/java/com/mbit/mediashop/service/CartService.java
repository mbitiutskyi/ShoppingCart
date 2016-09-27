package com.mbit.mediashop.service;

import com.mbit.mediashop.model.CartItem;
import com.mbit.mediashop.model.ShoppingCart;

/**
 * Created by mbitiutskyi.
 */
public interface CartService {

    ShoppingCart getShoppingCart();

    void addProductById(int id);

    void clearCart();

    void removeCartItemByProductId(int id);

}
