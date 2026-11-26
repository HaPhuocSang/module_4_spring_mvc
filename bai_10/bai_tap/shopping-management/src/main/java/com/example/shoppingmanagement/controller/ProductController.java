package com.example.shoppingmanagement.controller;

import com.example.shoppingmanagement.dto.ProductDto;
import com.example.shoppingmanagement.entity.Cart;
import com.example.shoppingmanagement.service.product.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
@SessionAttributes("cart")
public class ProductController {
    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart setCart() {
        return new Cart();
    }

    @GetMapping
    public String index(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Page<ProductDto> products = productService.findAll(page, 6);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") Long id, @ModelAttribute("cart")  Cart cart, Model model) {
        ProductDto product = productService.findById(id).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm này!"));
        int quantity = 0;
        var item = cart.selectItemInCart(product);
        if (item != null) {
            quantity = item.getValue();
        }
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantity);
        return "detail";
    }

    @PostMapping("/{id}/add")
    public String addToCart(@PathVariable("id") Long id, @ModelAttribute("cart")  Cart cart, @RequestParam("action") String action) {
        ProductDto product = productService.findById(id).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm này!"));
        cart.addProduct(product);
        if (action.equals("show")) {
            return "redirect:/shopping-cart";
        }
        return "redirect:/";
    }
}
