package org.example.bai_tap_2.controller;

import org.example.bai_tap_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping
    public String display() {
        return "index";
    }

    @PostMapping
    public String searchWord(@RequestParam("word") String word, Model model) {
        String meaning = dictionaryService.findByWord(word.toLowerCase());
        if (meaning == null) {
            model.addAttribute("word", word);
            model.addAttribute("error", "Không tìm thấy nghĩa của từ này!");
            return "index";
        }
        model.addAttribute("word", word);
        model.addAttribute("meaning", meaning);
        return "index";
    }
}
