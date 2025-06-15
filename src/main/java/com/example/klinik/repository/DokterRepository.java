package com.example.klinik.repository;

import com.example.klinik.entity.Dokter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DokterRepository extends JpaRepository<Dokter, Long> {
}

