package com.example.klinik.service;

import com.example.klinik.entity.Dokter;
import com.example.klinik.repository.DokterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DokterService {

    @Autowired
    private DokterRepository dokterRepository;

    public List<Dokter> findAll() {
        return dokterRepository.findAll();
    }

    public Dokter save(Dokter dokter) {
        return dokterRepository.save(dokter);
    }

    public Optional<Dokter> findById(Long id) {
        return dokterRepository.findById(id);
    }

    public void deleteById(Long id) {
        dokterRepository.deleteById(id);
    }
}

