package org.example.bai_tap_1.controller;

import org.example.bai_tap_1.enity.EmailSettings;
import org.example.bai_tap_1.service.email_setting.IEmailSettingService;
import org.example.bai_tap_1.service.language.ILanguageService;
import org.example.bai_tap_1.service.page_size.IPageSizeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller()
@RequestMapping("/")
public class EmailSettingController {
    private final ILanguageService languageService;
    private final IEmailSettingService emailSettingService;
    private final IPageSizeService pageSizeService;

    public EmailSettingController(ILanguageService languageService, IEmailSettingService emailSettingService, IPageSizeService pageSizeService) {
        this.languageService = languageService;
        this.emailSettingService = emailSettingService;
        this.pageSizeService = pageSizeService;
    }

    @ModelAttribute("emailSettings")
    public EmailSettings getEmailSettings() {
        return emailSettingService.getEmailSettings();
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("emailSettings", emailSettingService.getEmailSettings());
        model.addAttribute("languages", languageService.findALl());
        return "index";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        model.addAttribute("pageSizes", pageSizeService.findALl());
        model.addAttribute("languages", languageService.findALl());
        return "edit";
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute("emailSettings") EmailSettings emailSettings, RedirectAttributes redirectAttributes){
        emailSettingService.saveEmailSettings(emailSettings);
        redirectAttributes.addFlashAttribute("message", "Update successfully!");
        return "redirect:/";
    }
}
