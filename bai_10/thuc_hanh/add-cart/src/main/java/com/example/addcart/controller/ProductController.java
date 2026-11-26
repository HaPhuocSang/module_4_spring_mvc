package com.example.addcart.controller;

import com.example.addcart.entity.Cart;
import com.example.addcart.entity.Product;
import com.example.addcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            cart.addProduct(product.get());
        }
        if ("show".equals(action)) {
            return "redirect:/shopping-cart";
        }
        return "redirect:/shop";
    }
}