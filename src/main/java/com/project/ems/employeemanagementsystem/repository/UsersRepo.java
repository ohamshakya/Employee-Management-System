package com.project.ems.employeemanagementsystem.repository;

import com.project.ems.employeemanagementsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
