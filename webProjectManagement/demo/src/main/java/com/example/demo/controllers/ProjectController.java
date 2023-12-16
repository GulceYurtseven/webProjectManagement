package com.example.demo.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Project;
import com.example.demo.request.ProjectCreateRequest;
import com.example.demo.services.ProjectService;
import java.util.Optional;

//burada sadece fonksiyonlar service aracılığı ile çağrılıyor
@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;
    ProjectCreateRequest newProjectRequest;

    public ProjectController(ProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(@RequestParam Optional <Long> projectId) {
        return projectService.getAllProjects(projectId);
    }

    @PostMapping
    public Project createOnProject(@RequestBody ProjectCreateRequest newProjectRequest) {
        return projectService.createOneProject(newProjectRequest);
    }

    @GetMapping("{projectId}")
    public Project getOneProject(@PathVariable Long projectId) {
        return projectService.getOneProjectById(projectId);

    }

}

