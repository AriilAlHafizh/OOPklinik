package com.example.klinik.controller;

import com.example.klinik.entity.Dokter;
import com.example.klinik.repository.DokterRepository;
import com.example.klinik.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DokterController {

    @Autowired
    private DokterRepository dokterRepository;

    @GetMapping("/dokter")
    public String listDokter(Model model) {
        model.addAttribute("listDokter", dokterRepository.findAll());
        model.addAttribute("dokter", new Dokter());
        return "dokter"; // nama file HTML
    }

    @PostMapping("/dokter")
    public String simpan(@ModelAttribute Dokter dokter) {
        dokterRepository.save(dokter);
        return "redirect:/dokter";
    }

    @GetMapping("/dokter/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Dokter dokter = dokterRepository.findById(id).orElse(null);
        model.addAttribute("dokter", dokter);
        model.addAttribute("listDokter", dokterRepository.findAll());
        return "dokter";
    }

    @GetMapping("/dokter/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        dokterRepository.deleteById(id);
        return "redirect:/dokter";
    }
}
