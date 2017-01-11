package com.mbit.mediashop.controller;

import com.mbit.mediashop.model.ShoppingCart;
import com.mbit.mediashop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping
    public String home(Model model) {
        ShoppingCart shoppingCart = cartService.getShoppingCart();
        model.addAttribute(shoppingCart);
        return "cart";
    }

    @RequestMapping("/addProduct/{id}")
    public String addProduct(@PathVariable int id) {
        cartService.addProductById(id);
        return "redirect:/catalog";

    }

    @RequestMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable int id) {
        cartService.removeCartItemByProductId(id);
        return "redirect:/cart";
    }

    @RequestMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}
