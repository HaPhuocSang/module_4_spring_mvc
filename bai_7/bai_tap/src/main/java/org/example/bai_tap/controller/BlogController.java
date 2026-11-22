package org.example.bai_tap.controller;

import jakarta.validation.Valid;
import org.example.bai_tap.dto.BlogDto;
import org.example.bai_tap.service.blog.IBlogService;
import org.example.bai_tap.service.category.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class BlogController {
    private final IBlogService blogService;
    private final ICategoryService categoryService;

    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "6") Integer size, @RequestParam(defaultValue = "desc") String direction, Model model) {
        Page<BlogDto> blogs = blogService.findALl(page, size, direction);
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("size", size);
        model.addAttribute("direction", direction);
        model.addAttribute("categoryId", null);
        model.addAttribute("keyword", "");
        return "blog/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "6") Integer size, @RequestParam(defaultValue = "desc") String direction, Model model) {
        Page<BlogDto> blogs = blogService.search(keyword, page, size, direction);
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("keyword", keyword);
        model.addAttribute("size", size);
        model.addAttribute("direction", direction);
        model.addAttribute("categoryId", null);
        return "blog/index";
    }

    @GetMapping("/{id}/category")
    public String category(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "6") Integer size, @RequestParam(defaultValue = "desc") String direction, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id).isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Danh mục không tồn tại!");
            return "redirect:/";
        }
        Page<BlogDto> blogs = blogService.findByCategoryId(id, page, size, direction);
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("categoryId", id);
        model.addAttribute("size", size);
        model.addAttribute("direction", direction);
        model.addAttribute("keyword", "");
        return "blog/index";
    }

    @GetMapping("{id}/detail")
    public String blogDetail(@PathVariable("id") Long id, Model model) {
        Optional<BlogDto> blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "blog/detail";
        }
        return "404";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new BlogDto());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/form";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("blog") BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "blog/form";
        }
        boolean confirm = blogService.save(blogDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Create blog successfully!" : "Create blog failed!");
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable("id") Long id, Model model) {
        Optional<BlogDto> blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            model.addAttribute("categories", categoryService.findAll());
            return "blog/form";
        }
        return "404";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("blog") BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "blog/form";
        }
        boolean confirm = blogService.update(blogDto);
        redirectAttributes.addFlashAttribute("message", confirm ? "Update blog successfully!" : "Update blog failed!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        String message = blogService.remove(id) ? "Delete blog successfully" : "Delete blog failed";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
