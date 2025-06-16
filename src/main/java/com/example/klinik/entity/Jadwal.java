package com.example.klinik.entity;

import jakarta.persistence.*;

@Entity
public class Jadwal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hari;
    private String jamMulai;
    private String jamSelesai;

    @ManyToOne
    @JoinColumn(name = "dokter_id")  // FK ke tabel dokter
    private Dokter dokter;

    public Jadwal() {}

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    // 🔽 Tambahkan ini supaya bisa menerima dokterId dari form
    public Long getDokterId() {
        return (dokter != null) ? dokter.getId() : null;
    }

    public void setDokterId(Long dokterId) {
        if (this.dokter == null) {
            this.dokter = new Dokter();
        }
        this.dokter.setId(dokterId);
    }
}
