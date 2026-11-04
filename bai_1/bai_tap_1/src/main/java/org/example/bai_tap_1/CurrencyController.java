package org.example.bai_tap_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CurrencyController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/")
    public String post(@RequestParam("exchangeRate") Double exchangeRate, @RequestParam("usdAmount") Double usdAmount, Model model){
        if(exchangeRate == null || usdAmount == null || exchangeRate <=0 || usdAmount <=0) {
            model.addAttribute("usdAmount",usdAmount);
            model.addAttribute("exchangeRate",exchangeRate);
            model.addAttribute("error", "Tỉ giá hoặc lượng USD phải lớn hơn 0!");
            return "index";
        }
        Double result = exchangeRate * usdAmount;
        model.addAttribute("usdAmount",usdAmount);
        model.addAttribute("exchangeRate",exchangeRate);
        model.addAttribute("result",result);
        return "index";
    }
}
