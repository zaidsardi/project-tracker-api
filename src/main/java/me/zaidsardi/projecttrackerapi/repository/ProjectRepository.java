package me.zaidsardi.projecttrackerapi.repository;

import me.zaidsardi.projecttrackerapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer /* primary key*/ >  {
    @Query("SELECT p FROM Project p "+
            "where LOWER(p.title)"+
            "LIKE LOWER(CONCAT('%',:title,'%')) ")
    List<Project> searchProjects(String title);
}
