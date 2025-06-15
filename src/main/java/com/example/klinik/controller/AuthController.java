package com.example.klinik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.klinik.entity.Pasien;
import com.example.klinik.repository.PasienRepository;
import com.example.klinik.repository.AdminRepository;
import com.example.klinik.entity.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Controller
public class AuthController {

    @Autowired
    private PasienRepository pasienRepo;

    @Autowired
    private AdminRepository adminRepo;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("pasien", new Pasien());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Pasien pasien) {
    pasien.setRole("ROLE_USER"); // Tambahkan ini jika belum otomatis
    pasienRepo.save(pasien);
    return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    } 

    @GetMapping("/redirect")
public String redirectAfterLogin() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
        return "redirect:/admin/dashboard";
    } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
        return "redirect:/pasien/dashboard";
    } else {
        return "redirect:/login?error=unauthorized";
    }
}

}
