package com.example.klinik.repository;

import com.example.klinik.entity.Reservasi;
import com.example.klinik.entity.Pasien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasiRepository extends JpaRepository<Reservasi, Long> {

    // Ambil semua reservasi milik 1 pasien tertentu
    List<Reservasi> findByPasien(Pasien pasien);

    // Atau berdasarkan username pasien, jika kamu ingin query lebih cepat (harus pakai join fetch)
    // @Query("SELECT r FROM Reservasi r WHERE r.pasien.username = :username")
    // List<Reservasi> findByPasienUsername(@Param("username") String username);
}
