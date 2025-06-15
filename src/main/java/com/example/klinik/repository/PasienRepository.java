package com.example.klinik.repository;

import com.example.klinik.entity.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasienRepository extends JpaRepository<Pasien, Long> {
    Pasien findByUsername(String username);
}
