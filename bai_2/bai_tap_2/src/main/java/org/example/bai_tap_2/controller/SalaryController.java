package org.example.bai_tap_2.controller;

import org.example.bai_tap_2.service.IHourlyWageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class SalaryController {
    private final IHourlyWageService hourlyWageService;

    public  SalaryController(IHourlyWageService hourlyWageService) {
        this.hourlyWageService = hourlyWageService;
    }

    @GetMapping
    public String display(Model model) {
        model.addAttribute("hourlyWages", hourlyWageService.getHourlyWages());
        return "index";
    }
    @PostMapping("/payrollCalculation")
    public String payrollCalculation(@RequestParam(value = "morningHours", required = false) Double morningHours, @RequestParam(value = "afternoonHours", required = false) Double afternoonHours, @RequestParam(value = "eveningHours", required = false) Double eveningHours, @RequestParam("hourlySalary") Double hourlySalary, Model model, RedirectAttributes redirectAttributes) {
        morningHours = hourlyWageService.checkNumber(morningHours);
        afternoonHours = hourlyWageService.checkNumber(afternoonHours);
        eveningHours = hourlyWageService.checkNumber(eveningHours);
        hourlySalary = hourlyWageService.checkNumber(hourlySalary);
        Double totalHours = hourlyWageService.totalHourlyWages(morningHours, afternoonHours, eveningHours);
        Double totalSalary = hourlyWageService.totalSalary(totalHours, hourlySalary);
        redirectAttributes.addFlashAttribute("totalSalary", totalSalary);
        redirectAttributes.addFlashAttribute("totalHours", totalHours);
        redirectAttributes.addFlashAttribute("morningHours", morningHours);
        redirectAttributes.addFlashAttribute("afternoonHours", afternoonHours);
        redirectAttributes.addFlashAttribute("eveningHours", eveningHours);
        redirectAttributes.addFlashAttribute("hourlySalary", hourlySalary);
        return "redirect:/";
    }
}
