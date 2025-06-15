package com.example.klinik.service;

import com.example.klinik.entity.Admin;
import com.example.klinik.entity.Pasien;
import com.example.klinik.repository.PasienRepository;
import com.example.klinik.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasienRepository pasienRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Cek apakah user adalah admin
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            return new org.springframework.security.core.userdetails.User(
                    admin.getUsername(),
                    admin.getPassword(),
                    authorities
            );
        }

        // Jika bukan admin, cek apakah user adalah pasien
        Pasien pasien = pasienRepository.findByUsername(username);
        if (pasien != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new org.springframework.security.core.userdetails.User(
                    pasien.getUsername(),
                    pasien.getPassword(),
                    authorities
            );
        }

        throw new UsernameNotFoundException("User tidak ditemukan");
    }
}
