// package com.example.klinik.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.security.core.Authentication;

// @Controller
// public class LoginController {

//     @GetMapping("/login")
//     public String loginPage() {
//         return "login";
//     }

//     @GetMapping("/default")
//     public String defaultAfterLogin(Authentication auth) {
//         if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
//             return "redirect:/admin/dashboard";
//         } else {
//             return "redirect:/pasien";
//         }
//     }
// }

