package com.portback.portfolioback.services;

import com.portback.portfolioback.models.Project;
import com.portback.portfolioback.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository repo;

    public boolean projectExists(String id) {
        try{
            return repo.findById(id).isPresent();
        }catch (Exception e){
            return false;
        }

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
        if (project.getId() != null && projectExists(project.getId()))
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
