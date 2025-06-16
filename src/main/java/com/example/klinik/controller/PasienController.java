package com.example.klinik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasienController {

    @GetMapping("/pasien/dashboard")
    public String dashboard() {
        return "pasien/dashboard";
    }
}

