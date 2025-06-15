package com.example.klinik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/")
    public String landingPage() {
        return "LandingPage"; // pastikan nama file HTML-nya landing.html di folder templates
    }
}

