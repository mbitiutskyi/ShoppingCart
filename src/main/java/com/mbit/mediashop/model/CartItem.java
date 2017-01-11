package com.mbit.mediashop.model;

import java.math.BigDecimal;


public class CartItem {

    private Product product;
    private int quantity;
    private BigDecimal itemPrice;

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
