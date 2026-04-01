package me.zaidsardi.projecttrackerapi.repository;

import me.zaidsardi.projecttrackerapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer /* primary key*/ >  {
}
