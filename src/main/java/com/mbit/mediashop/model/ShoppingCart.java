package com.mbit.mediashop.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mbitiutskyi.
 */

@Component
@SessionScope
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 6275747495068248763L;

    private List<CartItem> cartItems;
    private int totalQuantity;
    private BigDecimal totalPrice;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
        totalQuantity = 0;
        totalPrice = new BigDecimal("0.00");
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addCartItem(CartItem cartItem) {
        for (CartItem item : cartItems) {
            if (cartItem.getProduct().getProductId() == item.getProduct().getProductId()) {
                item.increaseQuantity();
                item.updateTotalPrice();
                updateTotals();
                return;
            }
        }
        cartItems.add(cartItem);
        updateTotals();
    }

    public void removeItemByProductId(int id) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getProduct().getProductId() == id) {
                iterator.remove();
                break;
            }
        }
        updateTotals();
    }

    public void clearItems() {
        this.cartItems.clear();
        updateTotals();
    }

    private void updateTotals() {
        totalQuantity = 0;
        totalPrice = new BigDecimal("0.00");
        for (CartItem cartItem : cartItems) {
            totalQuantity += cartItem.getQuantity();
            totalPrice = totalPrice.add(cartItem.getItemPrice());
        }
    }
}
