package com.mbit.mediashop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mbitiutskyi.
 */

public class CartItem implements Serializable {

    private static final long serialVersionUID = -84973600454503363L;

    private Product product;
    private int quantity;
    private BigDecimal itemPrice;

    public CartItem() {
    }

    public CartItem(Product product) {
        this.product = product;
    }

    public CartItem(Product product, int quantity, BigDecimal totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.itemPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void updateTotalPrice() {
        itemPrice = product.getPrice().multiply(new BigDecimal(quantity));
    }

    public void increaseQuantity() {
        quantity++;
    }
}
