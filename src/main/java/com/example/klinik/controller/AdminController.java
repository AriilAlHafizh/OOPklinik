package com.example.klinik.controller;

import com.example.klinik.entity.Admin;
import com.example.klinik.entity.Pasien;
import com.example.klinik.entity.Dokter;
import com.example.klinik.repository.AdminRepository;
import com.example.klinik.repository.PasienRepository;
import com.example.klinik.repository.DokterRepository;

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
    private PasienRepository pasienRepository;

    @Autowired
    private DokterRepository dokterRepository;

    // ================= DASHBOARD =================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalAdmin", adminRepository.count());
        model.addAttribute("totalDokter", dokterRepository.count());
        model.addAttribute("totalPasien", pasienRepository.count());
        return "admin/dashboard-admin";
    }

    // ================= CRUD ADMIN =================
    @GetMapping("/kelola-admin")
    public String listAdmin(Model model) {
        model.addAttribute("listAdmin", adminRepository.findAll());
        model.addAttribute("admin", new Admin());
        return "admin/kelola-admin";
    }

    @PostMapping("/kelola-admin")
    public String simpanAdmin(@ModelAttribute Admin admin) {
        adminRepository.save(admin);
        return "redirect:/admin/kelola-admin";
    }

    @GetMapping("/kelola-admin/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model) {
        Admin admin = adminRepository.findById(id).orElse(null);
        model.addAttribute("admin", admin);
        model.addAttribute("listAdmin", adminRepository.findAll());
        return "admin/kelola-admin";
    }

    @GetMapping("/kelola-admin/hapus/{id}")
    public String hapusAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
        return "redirect:/admin/kelola-admin";
    }

    // ================= CRUD DOKTER =================
    @GetMapping("/dokter")
    public String listDokter(Model model) {
        model.addAttribute("listDokter", dokterRepository.findAll());
        model.addAttribute("dokter", new Dokter());
        return "admin/dokter";
    }

    @PostMapping("/dokter")
    public String simpanDokter(@ModelAttribute Dokter dokter) {
        dokterRepository.save(dokter);
        return "redirect:/admin/dokter";
    }

    @GetMapping("/dokter/edit/{id}")
    public String editDokter(@PathVariable Long id, Model model) {
        Dokter dokter = dokterRepository.findById(id).orElse(null);
        model.addAttribute("dokter", dokter);
        model.addAttribute("listDokter", dokterRepository.findAll());
        return "admin/dokter";
    }

    @GetMapping("/dokter/hapus/{id}")
    public String hapusDokter(@PathVariable Long id) {
        dokterRepository.deleteById(id);
        return "redirect:/admin/dokter";
    }

    // ================= CRUD PASIEN =================
    @GetMapping("/pasien")
    public String listPasien(Model model) {
        model.addAttribute("listPasien", pasienRepository.findAll());
        model.addAttribute("pasien", new Pasien());
        return "admin/pasien";
    }

    @PostMapping("/pasien")
    public String simpanPasien(@ModelAttribute Pasien pasien) {
        pasienRepository.save(pasien);
        return "redirect:/admin/pasien";
    }

    @GetMapping("/pasien/edit/{id}")
    public String editPasien(@PathVariable Long id, Model model) {
        Pasien pasien = pasienRepository.findById(id).orElse(null);
        model.addAttribute("pasien", pasien);
        model.addAttribute("listPasien", pasienRepository.findAll());
        return "admin/pasien";
    }

    @GetMapping("/pasien/hapus/{id}")
    public String hapusPasien(@PathVariable Long id) {
        pasienRepository.deleteById(id);
        return "redirect:/admin/pasien";
    }
}