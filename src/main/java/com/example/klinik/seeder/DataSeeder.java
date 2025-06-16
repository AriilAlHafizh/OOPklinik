package com.example.klinik.seeder;

import com.example.klinik.entity.Admin;
import com.example.klinik.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String username = "admin";
            String rawPassword = "admin123";
            String nama = "Administrator";

            // Cek apakah admin sudah ada
            if (adminRepository.findByUsername(username) == null) {
                Admin admin = new Admin();
                admin.setNama(nama);
                admin.setUsername(username);
                admin.setPassword(passwordEncoder.encode(rawPassword));
                admin.setRole("ADMIN");

                adminRepository.save(admin);
                System.out.println("Admin account created: " + username);
            } else {
                System.out.println("Admin account already exists.");
            }
        };
    }
}