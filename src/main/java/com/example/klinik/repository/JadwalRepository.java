package com.example.klinik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.klinik.entity.Jadwal;

public interface JadwalRepository extends JpaRepository<Jadwal, Long> {
    List<Jadwal> findByDokter_Id(Long dokterId); // kalau mau pakai filter nanti
}

