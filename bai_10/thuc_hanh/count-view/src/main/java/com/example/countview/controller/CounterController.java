package com.example.countview.controller;

import com.example.countview.entity.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
@RequestMapping("/")
public class CounterController {
    @ModelAttribute("counter")
    public Counter getCounter() {
        return new Counter();
    }
    @GetMapping
    public String index(@ModelAttribute("counter")  Counter counter) {
        counter.increment();
        return "index";
    }
}
