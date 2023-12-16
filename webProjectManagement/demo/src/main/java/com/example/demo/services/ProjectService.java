package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.repos.ProjectRepository;
import com.example.demo.request.ProjectCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(Optional<Long> projectId) {
        if (projectId.isPresent()) {
            // projectId verilmişse sadece belirtilen projeyi döndür
            return List.of(projectRepository.getById(projectId.get()));
        } else {
            // projectId verilmemişse tüm projeleri döndür
            return projectRepository.findAll();
        }
    }

    public Project createOneProject(ProjectCreateRequest newProjectRequest) {
        Project project = new Project();
        project.setProjectId(newProjectRequest.getProjectId());
        project.setProjectName(newProjectRequest.getProjectName());
        return projectRepository.save(project);
    }

    public Project getOneProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }
}
