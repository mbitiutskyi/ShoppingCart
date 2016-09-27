package com.mbit.mediashop.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
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

    public synchronized List<CartItem> getCartItems() {
        return cartItems;
    }

    public synchronized void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public synchronized int getTotalQuantity() {
        return totalQuantity;
    }

    public synchronized void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public synchronized BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public synchronized void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public synchronized void addCartItem(CartItem cartItem) {
        for (CartItem item : cartItems) {
            if (cartItem.getProduct().getProductId() == item.getProduct().getProductId()) {
                item.increaseQuantity();
                item.updateTotalPrice();
                this.updateTotals();
                return;
            }
        }
        cartItems.add(cartItem);
        this.updateTotals();
    }

    public synchronized void removeItemByProductId(int id) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getProduct().getProductId() == id) {
                iterator.remove();
                break;
            }
        }
        this.updateTotals();
    }

    public synchronized void clearItems() {
        this.cartItems.clear();
        this.updateTotals();
    }

    private synchronized void updateTotals() {
        totalQuantity = 0;
        totalPrice = new BigDecimal("0.00");
        for (CartItem cartItem : cartItems) {
            totalQuantity += cartItem.getQuantity();
            totalPrice = totalPrice.add(cartItem.getItemPrice());
        }
    }
}
