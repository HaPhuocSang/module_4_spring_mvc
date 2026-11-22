package org.example.valiadateformregister.controller;

import jakarta.validation.Valid;
import org.example.valiadateformregister.dto.UserDto;
import org.example.valiadateformregister.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class UserController {
    private final IUserService userService;
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        boolean result = userService.save(userDto);
        redirectAttributes.addFlashAttribute(result ? "message" : "error", result ? "Đăng ký thành công!" : "Đăng ký không thành công!");
        return "redirect:/";
    }
}
