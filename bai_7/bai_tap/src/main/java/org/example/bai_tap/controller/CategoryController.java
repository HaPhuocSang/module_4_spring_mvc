package org.example.bai_tap.controller;

import jakarta.validation.Valid;
import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.dto.CategoryDto;
import org.example.bai_tap.service.category.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(Model model) {
        Iterable<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new  CategoryDto());
        return "category/index";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("category") CategoryDto categoryDto, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "category/index";
        }
        boolean confirm = categoryService.save(categoryDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Create category successfully!" : "Create category failed!");
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public String index(@PathVariable("id") Long id, Model model) {
        Optional<CategoryDto> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("category", category.get());
            return "category/index";
        }
        return "404";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("category") CategoryDto categoryDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "category/index";
        }
        boolean confirm = categoryService.update(categoryDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Update category successfully!" : "Update category failed!");
        return "redirect:/categories";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        String message = categoryService.delete(id) ? "Delete category successfully" : "Delete category failed";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/categories";
    }
}
