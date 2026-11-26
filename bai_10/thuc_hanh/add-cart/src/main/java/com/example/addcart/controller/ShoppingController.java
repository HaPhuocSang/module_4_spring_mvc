package com.example.addcart.controller;

import com.example.addcart.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        if (cart == null) {
            cart = new Cart();
        }
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
