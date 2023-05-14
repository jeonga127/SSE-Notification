package com.example.wherebnbmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/main")
    public ModelAndView index() { return new ModelAndView("index.html"); }

    @GetMapping("/user")
    public ModelAndView user() { return new ModelAndView("user.html"); }
}
