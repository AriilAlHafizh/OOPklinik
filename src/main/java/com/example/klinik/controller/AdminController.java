package com.example.klinik.controller;

import com.example.klinik.entity.Admin;
import com.example.klinik.repository.DokterRepository;
import com.example.klinik.repository.PasienRepository;
import com.example.klinik.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DokterRepository dokterRepository;

    @Autowired
    private PasienRepository pasienRepository;

    // =================== Dashboard ===================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalDokter", dokterRepository.count());
        model.addAttribute("totalPasien", pasienRepository.count());
        // Jika ada tabel reservasi, bisa ditambahkan di sini:
        // model.addAttribute("totalReservasi", reservasiRepository.count());
        return "admin/dashboard-admin"; // pastikan file HTML ini tersedia di /templates/admin/
    }

    // =================== CRUD Admin ===================
    @GetMapping("/kelola")
    public String listAdmin(Model model) {
        model.addAttribute("listAdmin", adminRepository.findAll());
        model.addAttribute("admin", new Admin());
        return "admin/kelola-admin"; // pastikan file HTML ini tersedia di /templates/admin/
    }

    @PostMapping("/kelola")
    public String simpan(@ModelAttribute Admin admin) {
        adminRepository.save(admin);
        return "redirect:/admin/kelola";
    }

    @GetMapping("/kelola/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Admin admin = adminRepository.findById(id).orElse(null);
        model.addAttribute("admin", admin);
        model.addAttribute("listAdmin", adminRepository.findAll());
        return "admin/kelola-admin";
    }

    @GetMapping("/kelola/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        adminRepository.deleteById(id);
        return "redirect:/admin/kelola";
    }
}
