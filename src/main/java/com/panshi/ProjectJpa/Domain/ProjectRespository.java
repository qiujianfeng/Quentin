package com.panshi.ProjectJpa.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRespository extends JpaRepository<Project, Integer>{

	public Project findByProjectName(String name);
}
