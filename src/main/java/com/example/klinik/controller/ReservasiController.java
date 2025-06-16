package com.example.klinik.controller;

import com.example.klinik.entity.Jadwal;
import com.example.klinik.entity.Pasien;
import com.example.klinik.entity.Reservasi;
import com.example.klinik.entity.Dokter;
import com.example.klinik.repository.JadwalRepository;
import com.example.klinik.repository.PasienRepository;
import com.example.klinik.repository.ReservasiRepository;
import com.example.klinik.repository.DokterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private DokterRepository dokterRepository;

    @GetMapping
    public String showReservasiPage(Model model, Principal principal) {
        String username = principal.getName();
        Pasien pasien = pasienRepository.findByUsername(username);

        if (pasien == null) {
            return "redirect:/pasien/profil";
        }

        List<Dokter> listDokter = dokterRepository.findAll();
        model.addAttribute("reservasi", new Reservasi());
        model.addAttribute("listDokter", listDokter);
        model.addAttribute("pasien", pasien);

        return "reservasi";
    }

    @PostMapping("/buat")
    public String buatReservasi(@ModelAttribute Reservasi reservasi, Principal principal) {
        String username = principal.getName();
        Pasien pasien = pasienRepository.findByUsername(username);

        if (pasien == null) {
            return "redirect:/pasien/profil";
        }

        reservasi.setPasien(pasien);
        reservasiRepository.save(reservasi);

        return "redirect:/pasien/dashboard";
    }

    // Untuk AJAX: Ambil daftar jadwal berdasarkan dokter
    @GetMapping("/jadwal-by-dokter/{dokterId}")
    @ResponseBody
    public ResponseEntity<List<Jadwal>> getJadwalByDokter(@PathVariable Long dokterId) {
        List<Jadwal> jadwalList = jadwalRepository.findByDokter_Id(dokterId);
        return ResponseEntity.ok(jadwalList);
    }
}
