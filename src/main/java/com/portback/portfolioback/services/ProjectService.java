package com.portback.portfolioback.services;

import com.portback.portfolioback.models.Project;
import com.portback.portfolioback.repositories.ProjectRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ProjectService {
    private ProjectRepository repo;

    public boolean projectExists(String id) {
        return repo.findById(id).isPresent();
    }

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public Project updateProject(Project project) {
        Optional<Project> optProj = repo.findById(project.getId());
        if (optProj.isPresent()) {
            Project newProj = optProj.get();
            newProj.setName(project.getName());
            newProj.setName(project.getDescription());

            repo.save(newProj);
            return repo.findById(newProj.getId()).get();
        } else {
            throw new RuntimeException("Invalid project ID for update: " + project.getId());
        }
    }

    public Project insertProject(Project project) {
        if (projectExists(project.getId()))
            throw new RuntimeException();
        return repo.save(project);
    }

    public void deleteProject(String id){
        if (repo.findById(id).isEmpty())
            throw new RuntimeException("Invalid project ID for deleting: " + id);
        repo.deleteById(id);
    }

    public Optional<Project> getProject(String id){
        return repo.findById(id);
    }

}
