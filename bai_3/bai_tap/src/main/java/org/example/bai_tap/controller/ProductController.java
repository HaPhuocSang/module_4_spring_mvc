package org.example.bai_tap.controller;

import jakarta.validation.Valid;
import org.example.bai_tap.enity.Product;
import org.example.bai_tap.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "list";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("keyword")  String keyword, Model model) {
        List<Product> products = productService.findProductByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        String message = productService.addProduct(product) ? "Create product successfully" : "Create product failed";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String showEditProduct(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        String message = productService.updateProduct(product) ? "Update product successfully" : "Update product failed";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping("{id}/detail")
    public String showProductDetail(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") Integer id, RedirectAttributes redirectAttributes) {
        String message = productService.deleteProduct(id) ? "Delete product successfully" : "Delete product failed";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
