package com.example.demojsp.controller;

import com.example.demojsp.model.Name;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RedirectWithFlashAttributesController {
    @GetMapping("/home")
    public ModelAndView home(@RequestParam(required = false) String name) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name2", "Static Name");
        objectMap.put("name3", "Static Name2");
        objectMap.put("fname", new Name("Tapu", "Sutradhar"));
        return new ModelAndView("home").addObject("name", name).addAllObjects(objectMap);
    }

    @GetMapping("/next")
    public ModelAndView next(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("redirectName", "NICE");
        return new ModelAndView("redirect:/home");
    }
}
