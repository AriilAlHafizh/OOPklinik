package com.example.klinik.controller;

import com.example.klinik.entity.Jadwal;
import com.example.klinik.entity.Pasien;
import com.example.klinik.entity.Reservasi;
import com.example.klinik.repository.JadwalRepository;
import com.example.klinik.repository.PasienRepository;
import com.example.klinik.repository.ReservasiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/reservasi")
public class ReservasiController {

    @Autowired
    private JadwalRepository jadwalRepository;

    @Autowired
    private PasienRepository pasienRepository;

    @Autowired
    private ReservasiRepository reservasiRepository;

    @GetMapping
    public String showReservasiPage(Model model, Principal principal) {
        String username = principal.getName(); // Ambil username login
        Pasien pasien = pasienRepository.findByUsername(username); // Ambil pasien berdasarkan username

        if (pasien == null) {
            // Jika user belum punya data pasien, arahkan ke pengisian profil / error
            return "redirect:/pasien/profil";
        }

        List<Jadwal> jadwals = jadwalRepository.findAll();

        model.addAttribute("reservasi", new Reservasi());
        model.addAttribute("jadwals", jadwals);
        model.addAttribute("pasien", pasien); // untuk ditampilkan jika perlu

        return "reservasi"; // templates/reservasi.html
    }

    @PostMapping("/buat")
    public String buatReservasi(@ModelAttribute Reservasi reservasi, Principal principal) {
        String username = principal.getName();
        Pasien pasien = pasienRepository.findByUsername(username);

        if (pasien == null) {
            return "redirect:/pasien/profil"; // redirect jika data pasien belum ada
        }

        reservasi.setPasien(pasien);
        reservasiRepository.save(reservasi);

        return "redirect:/pasien/dashboard"; // setelah simpan, kembali ke dashboard
    }
}
