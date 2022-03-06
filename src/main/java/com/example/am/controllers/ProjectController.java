package com.example.am.controllers;

import com.example.am.models.Project;
import com.example.am.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;
    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
    @GetMapping("/projects/{id}")
    public Optional<Project> getProjectById(@PathVariable long id){
       return projectRepository.findById(id);
    }
    @PostMapping("projects")
    public Project saveProject(@RequestBody Project project){
       return projectRepository.save(project);
    }
    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable long id ,@RequestBody Project project) throws Exception {
        Project updatedProject = projectRepository.findById(id).orElseThrow(()-> new Exception("Project doesn't exist"));;
        updatedProject.setName(project.getName());
        updatedProject.setDescription(project.getDescription());
        return projectRepository.save(updatedProject);
    }
    @DeleteMapping("projects/{id}")
    public void deleteProject(@PathVariable long id){
        projectRepository.deleteById(id);
    }

}
