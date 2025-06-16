package com.example.klinik.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pasien_id", nullable = false)
    private Pasien pasien;

    @ManyToOne(optional = false)
    @JoinColumn(name = "jadwal_id", nullable = false)
    private Jadwal jadwal;

    @Column(nullable = false)
    private String keluhan;

    @Column(nullable = false)
    private String status = "pending"; // default status

    @Column(nullable = false)
    private LocalDate tanggalReservasi;

    // Constructors
    public Reservasi() {}

    public Reservasi(Long id, Pasien pasien, Jadwal jadwal, String keluhan, String status, LocalDate tanggalReservasi) {
        this.id = id;
        this.pasien = pasien;
        this.jadwal = jadwal;
        this.keluhan = keluhan;
        this.status = status;
        this.tanggalReservasi = tanggalReservasi;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTanggalReservasi() {
        return tanggalReservasi;
    }

    public void setTanggalReservasi(LocalDate tanggalReservasi) {
        this.tanggalReservasi = tanggalReservasi;
    }
}
