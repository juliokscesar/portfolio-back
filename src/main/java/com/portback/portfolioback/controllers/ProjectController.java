package com.portback.portfolioback.controllers;

import com.portback.portfolioback.models.Project;
import com.portback.portfolioback.repositories.ProjectRepository;
import com.portback.portfolioback.services.ProjectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/listall")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = service.getAllProjects();
        System.out.println("Request to projects/listall: "+projects);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProject(@RequestBody Project project){
        try {
            Project newProject = service.insertProject(project);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Projeto cadastrado com sucesso! ID: "+newProject.getId());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao cadastrar projeto: "+e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProject(@RequestBody Project project) {
        try {
            Project updated = service.updateProject(project);
            return ResponseEntity.ok("Successfully updated project (ID " + updated.getId() + ")");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to find project (ID " + project.getId() + ")");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable String id){
        service.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Project>> getProject(@PathVariable String id){
        Optional<Project> project = service.getProject(id);
        if(project.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find project");
        }else {
            return ResponseEntity.ok(project);
        }
    }
}
