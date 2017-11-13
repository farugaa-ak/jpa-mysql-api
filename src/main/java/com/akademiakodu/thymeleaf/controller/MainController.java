package com.akademiakodu.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(ModelMap  modelMap) {
        modelMap.addAttribute("message", "hello akademia");

        return "index";  //Thymeleaf //file path
    }

    @GetMapping("/{tekst}")
    public String indexWithText(ModelMap  modelMap, @PathVariable String tekst) {
        modelMap.addAttribute("message", tekst);

        return "hello/hello";
    }

    @GetMapping("if")
    public String condition(ModelMap modelMap){
        String attributeValue = "Asd";
        modelMap.addAttribute("text", attributeValue);
        return "if";
    }
}
