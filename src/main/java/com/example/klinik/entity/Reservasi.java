package com.example.klinik.entity;

import jakarta.persistence.*;

@Entity
public class Reservasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pasien pasien;

    @ManyToOne
    private Jadwal jadwal;

    private String keluhan;

    public Reservasi() {}

    public Reservasi(Long id, Pasien pasien, Jadwal jadwal, String keluhan) {
        this.id = id;
        this.pasien = pasien;
        this.jadwal = jadwal;
        this.keluhan = keluhan;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Pasien getPasien() { return pasien; }
    public void setPasien(Pasien pasien) { this.pasien = pasien; }

    public Jadwal getJadwal() { return jadwal; }
    public void setJadwal(Jadwal jadwal) { this.jadwal = jadwal; }

    public String getKeluhan() { return keluhan; }
    public void setKeluhan(String keluhan) { this.keluhan = keluhan; }
}

