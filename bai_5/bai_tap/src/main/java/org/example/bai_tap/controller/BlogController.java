package org.example.bai_tap.controller;

import jakarta.validation.Valid;
import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class BlogController {
    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "index";
    }

    @GetMapping("{id}/detail")
    public String blogDetail(@PathVariable("id") Integer id,  Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new BlogDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("blog") BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        boolean confirm = blogService.save(blogDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Create blog successfully!" : "Create blog failed!");
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("blog") BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        boolean confirm = blogService.save(blogDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Update blog successfully!" : "Update blog failed!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id,  RedirectAttributes redirectAttributes) {
        String message = blogService.remove(id) ? "Delete product successfully" : "Delete product failed";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
