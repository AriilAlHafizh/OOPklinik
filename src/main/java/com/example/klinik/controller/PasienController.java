package com.example.klinik.controller;

import com.example.klinik.entity.Pasien;
import com.example.klinik.repository.PasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class PasienController {

    @Autowired
    private PasienRepository pasienRepository;

    // Dashboard setelah login pasien
    @GetMapping("/pasien/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Pasien pasien = (Pasien) session.getAttribute("pasien");
        if (pasien == null) {
            return "redirect:/login";
        }
        model.addAttribute("pasien", pasien);
        return "pasien/dashboard"; // Pastikan ada templates/pasien/dashboard.html
    }

    // Menampilkan semua data pasien (hanya untuk admin, misalnya)
    @GetMapping("/pasien")
    public String listPasien(Model model) {
        model.addAttribute("listPasien", pasienRepository.findAll());
        model.addAttribute("pasien", new Pasien());
        return "pasien";
    }

    // Simpan pasien baru atau update
    @PostMapping("/pasien")
    public String simpan(@ModelAttribute Pasien pasien) {
        pasienRepository.save(pasien);
        return "redirect:/pasien";
    }

    // Edit data pasien
    @GetMapping("/pasien/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Pasien pasien = pasienRepository.findById(id).orElse(null);
        model.addAttribute("pasien", pasien);
        model.addAttribute("listPasien", pasienRepository.findAll());
        return "pasien";
    }

    // Hapus pasien
    @GetMapping("/pasien/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        pasienRepository.deleteById(id);
        return "redirect:/pasien";
    }
}
