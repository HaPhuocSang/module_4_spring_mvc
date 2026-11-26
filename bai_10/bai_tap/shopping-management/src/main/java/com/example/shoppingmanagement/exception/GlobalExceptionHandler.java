package com.example.shoppingmanagement.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({IllegalStateException.class, IllegalArgumentException.class})
    public String handleException(RuntimeException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "404";
    }

    @ExceptionHandler({Exception.class})
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Đã xảy ra lỗi hệ thống!");
        return "404";
    }
}
