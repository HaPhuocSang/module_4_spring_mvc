package org.example.bai_tap2.controller;


import jakarta.validation.Valid;
import org.example.bai_tap2.enity.HealthDeclaration;
import org.example.bai_tap2.service.HealthDeclarationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HealthDeclarationController {
    private final HealthDeclarationService healthDeclarationService;

    public HealthDeclarationController(HealthDeclarationService healthDeclarationService) {
        this.healthDeclarationService = healthDeclarationService;
    }

    @ModelAttribute("declaration")
    public HealthDeclaration initHealthDeclaration(){
        return healthDeclarationService.find();
    }

    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@Valid @ModelAttribute("declaration") HealthDeclaration declaration, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        healthDeclarationService.save(declaration);
        return "redirect:/detail";
    }
    @GetMapping("/detail")
    public String detail(Model model) {
        HealthDeclaration healthDeclaration = healthDeclarationService.find();
        if (!healthDeclarationService.hasData()) {
            return "redirect:/";
        }
        model.addAttribute("declaration", healthDeclaration);
        return "detail";
    }
}
