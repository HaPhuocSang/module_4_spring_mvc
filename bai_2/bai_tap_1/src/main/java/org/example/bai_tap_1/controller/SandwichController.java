package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.service.ISandwichService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class SandwichController {
    private final ISandwichService sandwichService;

    public SandwichController(ISandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping
    public String display(Model model) {
        model.addAttribute("spices", sandwichService.list());
        return "index";
    }

    @PostMapping("/save")
    public String save (@RequestParam(value = "condiments" , required = false) List<String> condiments, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("condiments", condiments);
        redirectAttributes.addFlashAttribute("submitted", true);
        return "redirect:/";
    }
}
