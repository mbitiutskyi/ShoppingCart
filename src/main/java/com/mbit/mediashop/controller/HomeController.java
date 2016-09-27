package com.mbit.mediashop.controller;

import com.mbit.mediashop.model.ShoppingCart;
import com.mbit.mediashop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mbitiutskyi.
 */

@Controller
public class HomeController {

    private CartService cartService;

    @Autowired
    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        ShoppingCart shoppingCart = cartService.getShoppingCart();
        model.addAttribute(shoppingCart);
        return "home";
    }
}
