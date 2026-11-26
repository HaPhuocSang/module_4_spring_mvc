package com.example.shoppingmanagement.controller;

import com.example.shoppingmanagement.dto.CustomerOrderDto;
import com.example.shoppingmanagement.entity.Cart;
import com.example.shoppingmanagement.service.customer_order.ICustomerOrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    private final ICustomerOrderService customerOrderService;

    public CheckoutController(ICustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }


    @GetMapping
    public String checkout(@SessionAttribute(value = "cart", required = false) Cart cart, Model model) {
        if (cart == null || cart.getProductDtoMap().isEmpty()) {
            cart = new Cart();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("customerOrder", new CustomerOrderDto());
        return "checkout";
    }

    @PostMapping
    public String placeOrder(@Valid @ModelAttribute("customerOrder") CustomerOrderDto customerOrderDto, BindingResult bindingResult, @SessionAttribute(value = "cart", required = false) Cart cart, Model model, RedirectAttributes redirectAttributes) {
        if(cart == null || cart.getProductDtoMap().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Giỏ hàng của bạn đang trống!");
            return "redirect:/shopping-cart";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("cart", cart);
            return "checkout";
        }
        if (customerOrderService.createOrder(customerOrderDto, cart)) {
            cart.clearCart();
            redirectAttributes.addFlashAttribute("success", "Đặt hàng thành công!");
            return "redirect:/shopping-cart";
        }
        redirectAttributes.addFlashAttribute("error", "Đặt hàng không thành công!");
        return "redirect:/shopping-cart";
    }
}
