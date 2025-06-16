// package com.example.klinik.service;
// import com.example.klinik.entity.AdminDetails;
// import com.example.klinik.repository.AdminRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import com.example.klinik.entity.Admin;

// @Service
// public class AdminDetailsService implements UserDetailsService {

//     @Autowired
//     private AdminRepository adminRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Admin admin = adminRepository.findByUsername(username);
//         if (admin == null) {
//             throw new UsernameNotFoundException("Admin not found with username: " + username);
//         }

//         // Kembalikan UserDetails menggunakan class pembungkus, misalnya AdminDetails
//         return new AdminDetails(admin);
//     }
// }

