// package com.example.klinik.entity;

// import com.example.klinik.entity.Admin;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import java.util.Collection;
// import java.util.Collections;

// public class AdminDetails implements UserDetails {

//     private final Admin admin;

//     public AdminDetails(Admin admin) {
//         this.admin = admin;
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         // Role harus diawali dengan "ROLE_"
//         return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + admin.getRole()));
//     }

//     @Override
//     public String getPassword() {
//         return admin.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         return admin.getUsername();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }

//     public String getNama() {
//         return admin.getNama();
//     }

//     public Long getId() {
//         return admin.getId();
//     }

//     public String getRole() {
//         return admin.getRole();
//     }
// }

