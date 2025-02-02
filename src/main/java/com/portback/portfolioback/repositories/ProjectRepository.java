package com.portback.portfolioback.repositories;

import com.portback.portfolioback.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> { // tipo do valor do repositorio (Project) e tipo do ID (String)
    public Project findByName(String name);
}
