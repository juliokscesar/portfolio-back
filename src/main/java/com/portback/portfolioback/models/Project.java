package com.portback.portfolioback.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

@Document("project") // nome da coleção na db
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private String imagePath;
    private String repositoryLink;
    private LocalDate completionDate;

    public Project(String name, String description, String imagePath, String repositoryLink, LocalDate completionDate) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.repositoryLink = repositoryLink;
        this.completionDate = completionDate;
    }

    public String getId() {
        return id;
    }

    public String setId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() { return imagePath; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getRepositoryLink() { return repositoryLink; }

    public void setRepositoryLink(String repositoryLink) { this.repositoryLink = repositoryLink; }

    public LocalDate getCompletionDate() { return completionDate; }

    public void setCompletionDate(LocalDate completionDate) { this.completionDate = completionDate; }


    @Override
    public String toString() {
        return String.format(
                "Project[id=%s, name=%s, description=%s, imagePath=%s, repositoryLink=%s, completionDate=%s]",
                id, name, description, imagePath, repositoryLink, completionDate);
    }
}
