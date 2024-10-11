package com.argus.ecommerce.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardView {
    @GetMapping("/dashboard")
    public String index(Model model) {
        model.addAttribute("message", "Wellcome to dashboard");
        return "dashboard";
    }
}