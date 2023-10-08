package com.taskapp.be.controller;

import com.taskapp.be.dto.request.ProjectRequest;
import com.taskapp.be.model.Project;
import com.taskapp.be.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/{username}")
    public ResponseEntity<?> createProjectByUser(@RequestBody ProjectRequest projectRequest, @PathVariable String username) {
        projectService.createNewProject(projectRequest, username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all/{username}")
    public List<Project> getProjectsByUser(@PathVariable String username) {
        return projectService.getAllProjectsForUser(username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {
        projectService.getProjectById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProjectInfo(@RequestBody ProjectRequest projectRequest, @PathVariable long id) {
        projectService.updateProject(projectRequest, id);
        return ResponseEntity.ok().build();
    }

//    @DeleteMapping("/delete/{id}")
}
