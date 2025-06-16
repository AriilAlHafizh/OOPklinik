package com.example.klinik.controller;

import com.example.klinik.entity.*;
import com.example.klinik.repository.*;



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

    @Autowired
    private JadwalRepository jadwalRepository;

    @Autowired
    private ReservasiRepository reservasiRepository;

    // ================= DASHBOARD =================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalAdmin", adminRepository.count());
        model.addAttribute("totalDokter", dokterRepository.count());
        model.addAttribute("totalPasien", pasienRepository.count());
        model.addAttribute("totalReservasi", reservasiRepository.count());
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

    // ================= CRUD JADWAL =================
    @GetMapping("/jadwal")
    public String listJadwal(Model model) {
        model.addAttribute("listJadwal", jadwalRepository.findAll());
        model.addAttribute("jadwal", new Jadwal());
        model.addAttribute("listDokter", dokterRepository.findAll());
        return "admin/jadwal";
    }

    @PostMapping("/jadwal")
    public String simpanJadwal(@ModelAttribute Jadwal jadwal) {
        jadwalRepository.save(jadwal);
        return "redirect:/admin/jadwal";
    }

    @GetMapping("/jadwal/edit/{id}")
    public String editJadwal(@PathVariable Long id, Model model) {
        Jadwal jadwal = jadwalRepository.findById(id).orElse(null);
        model.addAttribute("jadwal", jadwal);
        model.addAttribute("listJadwal", jadwalRepository.findAll());
        model.addAttribute("listDokter", dokterRepository.findAll());
        return "admin/jadwal";
    }

    @GetMapping("/jadwal/hapus/{id}")
    public String hapusJadwal(@PathVariable Long id) {
        jadwalRepository.deleteById(id);
        return "redirect:/admin/jadwal";
    }

    // ================= LIHAT RESERVASI =================
    @GetMapping("/reservasi")
    public String listReservasi(Model model) {
        model.addAttribute("listReservasi", reservasiRepository.findAll());
        model.addAttribute("listPasien", pasienRepository.findAll());
        model.addAttribute("listJadwal", jadwalRepository.findAll());
        model.addAttribute("reservasi", new Reservasi());
        return "admin/reservasi";
    }

    @PostMapping("/reservasi")
    public String simpanReservasi(@ModelAttribute Reservasi reservasi) {
        reservasiRepository.save(reservasi);
        return "redirect:/admin/reservasi";
    }

    @GetMapping("/reservasi/edit/{id}")
    public String editReservasi(@PathVariable Long id, Model model) {
        Reservasi reservasi = reservasiRepository.findById(id).orElse(null);
        model.addAttribute("reservasi", reservasi);
        model.addAttribute("listPasien", pasienRepository.findAll());
        model.addAttribute("listJadwal", jadwalRepository.findAll());
        model.addAttribute("listReservasi", reservasiRepository.findAll());
        return "admin/reservasi";
    }

    @GetMapping("/reservasi/hapus/{id}")
    public String hapusReservasi(@PathVariable Long id) {
        reservasiRepository.deleteById(id);
        return "redirect:/admin/reservasi";
    }

    // ================= API Untuk JS =================
    @ResponseBody
    @GetMapping("/reservasi/pasien/{id}")
    public Pasien getPasienById(@PathVariable Long id) {
        return pasienRepository.findById(id).orElse(null);
    }

    @ResponseBody
    @GetMapping("/reservasi/jadwal/{id}")
    public Jadwal getJadwalById(@PathVariable Long id) {
        return jadwalRepository.findById(id).orElse(null);
    }
}
