package com.example.demo.repos;

import com.example.demo.entities.ProjectMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMembers, Long> {
}
