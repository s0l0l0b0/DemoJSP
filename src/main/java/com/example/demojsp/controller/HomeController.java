package com.example.demojsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView home(@RequestParam(required = false) String name) {
        return new ModelAndView("home").addObject("name", name);
    }

    @GetMapping("/next")
    public ModelAndView next(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("name2", "NICE");
        return new ModelAndView("redirect:/home");
    }
}
