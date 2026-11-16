package org.example.productmanagegment.controller;

import lombok.AllArgsConstructor;
import org.example.productmanagegment.dto.ProductDto;
import org.example.productmanagegment.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ProductController {
    private  final IProductService productService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("products",productService.findAll());
        return  "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") ProductDto productDto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "create";
        }
        boolean confirm = productService.save(productDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Create product successfully!" : "Create product failed!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") Long id){
        Optional<ProductDto> productDto = productService.findById(id);
        if(productDto.isPresent()){
            model.addAttribute("product", productDto.get());
            return "edit";
        }
        return "404";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") ProductDto productDto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "edit";
        }
        boolean confirm = productService.update(productDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Update product successfully!" : "Update product failed!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        boolean confirm = productService.remove(id);
        redirectAttributes.addFlashAttribute("message", confirm ? "Delete product successfully!" : "Delete product failed!");
        return "redirect:/";
    }
}
