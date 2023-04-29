package com.example.todoapp.admin;

import com.example.todoapp.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
