package com.example.klinik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.klinik.entity.Reservasi;

@Repository
public interface ReservasiRepository extends JpaRepository<Reservasi, Long> {
}
