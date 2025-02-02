package com.portback.portfolioback;

import com.portback.portfolioback.models.Project;
import com.portback.portfolioback.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		projRepo.deleteAll();
//
//		// save test
//		projRepo.save(new Project("Hello World", "First project"));
//		projRepo.save(new Project("Second" ,"Project"));
//
//		System.out.println("All projects found:");
//		for (Project proj : projRepo.findAll()) {
//			System.out.println(proj);
//		}
//	}
}
