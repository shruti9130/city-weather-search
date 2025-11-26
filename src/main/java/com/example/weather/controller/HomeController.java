package com.example.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Redirect root URL to weather.html
    @GetMapping("/")
    public String redirectToWeather() {
        return "redirect:/weather.html";
    }
    
    // Optional: Keep /weather redirect as well
    @GetMapping("/weather")
    public String redirectWeather() {
        return "redirect:/weather.html";
    }
}
