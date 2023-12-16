package com.example.demo.repos;

import com.example.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project,Long> {
}
