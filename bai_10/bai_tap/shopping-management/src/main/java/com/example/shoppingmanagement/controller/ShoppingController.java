package com.example.shoppingmanagement.controller;

import com.example.shoppingmanagement.dto.ProductDto;
import com.example.shoppingmanagement.entity.Cart;
import com.example.shoppingmanagement.service.product.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingController {
    private final IProductService productService;
    public ShoppingController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showCart(@SessionAttribute(value = "cart", required = false) Cart cart, Model model) {
        if (cart == null) {
            cart = new Cart();
        }
        model.addAttribute("cart", cart);
        return "shopping-cart";
    }

    @PostMapping("/{id}/increase")
    public String increaseCart(@PathVariable("id") Long id, @SessionAttribute(value = "cart", required = false) Cart cart) {
        if (cart == null) {
            return "redirect:/";
        }
        ProductDto productDto = productService.findById(id).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm này!"));
        cart.increaseProduct(productDto);
        return "redirect:/shopping-cart";
    }

    @PostMapping("/{id}/decrease")
    public String decreaseCart(@PathVariable("id") Long id, @SessionAttribute(value = "cart", required = false) Cart cart) {
        if (cart == null) {
            return "redirect:/";
        }
        ProductDto productDto = productService.findById(id).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm này!"));
        cart.decreaseProduct(productDto);
        return "redirect:/shopping-cart";
    }
    @PostMapping("/update")
    public String updateCart(@RequestParam Long productId, @RequestParam Integer quantity, @SessionAttribute(value = "cart", required = false) Cart cart, Model model) {
        if (cart == null) {
            return "redirect:/";
        }
        ProductDto productDto = productService.findById(productId).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm này!"));
        cart.updateProduct(productDto, quantity);
        return "redirect:/shopping-cart";
    }
    @PostMapping("/{id}/remove")
    public String removeCart(@PathVariable("id") Long id, @SessionAttribute(value = "cart", required = false) Cart cart) {
        if (cart == null) {
            return "redirect:/";
        }
        ProductDto productDto = productService.findById(id).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm này!"));
        cart.removeProduct(productDto);
        return "redirect:/shopping-cart";
    }
}
