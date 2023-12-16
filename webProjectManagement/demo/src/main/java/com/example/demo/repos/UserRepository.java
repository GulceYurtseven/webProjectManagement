package com.example.demo.repos;

import com.example.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Users,Long> {
}
