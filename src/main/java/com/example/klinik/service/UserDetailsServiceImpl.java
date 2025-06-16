package com.example.klinik.service;

import com.example.klinik.entity.Admin;
import com.example.klinik.entity.Pasien;
import com.example.klinik.repository.AdminRepository;
import com.example.klinik.repository.PasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final PasienRepository pasienRepository;

    @Autowired
    public UserDetailsServiceImpl(AdminRepository adminRepository, PasienRepository pasienRepository) {
        this.adminRepository = adminRepository;
        this.pasienRepository = pasienRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Cek Admin
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(
                admin.getUsername(),
                admin.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }

        // Cek Pasien
        Pasien pasien = pasienRepository.findByUsername(username);
        if (pasien != null) {
            return new org.springframework.security.core.userdetails.User(
                pasien.getUsername(),
                pasien.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );
        }

        throw new UsernameNotFoundException("Akun dengan username '" + username + "' tidak ditemukan");
    }
}
