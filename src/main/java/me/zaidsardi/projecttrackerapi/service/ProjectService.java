package me.zaidsardi.projecttrackerapi.service;

import me.zaidsardi.projecttrackerapi.model.ProjectStatus;
import me.zaidsardi.projecttrackerapi.model.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProjectService {
    private List<Project> projectList = new ArrayList<>(Arrays.asList(
            new Project(101,"Clinic Appointment API","Spring-boot", ProjectStatus.IN_PROGRESS),
            new Project(102,"Task Tracker API","nodeJS",ProjectStatus.PLANNED),
            new Project(103,"Portfolio ","HTML/CSS/Javascript",ProjectStatus.COMPLETED)
    ));


    public List<Project> getProjects(ProjectStatus status) {
        if (status == null)
            return projectList;
        else
            return projectList.stream()
                    .filter(s -> s.getStatus()==status)
                    .toList();
    }

    public Project addProject(Project project) {
         projectList.add(project);
         return project;
    }

    public Project updateProject(int id, Project updatedProject) {
        for ( Project existingProject : projectList ){
            if (existingProject.getId() == id){
                existingProject.setTitle(updatedProject.getTitle());
                existingProject.setStatus(updatedProject.getStatus());
                existingProject.setTechStack(updatedProject.getTechStack());
                return existingProject;
            }
        }
        return null;
    }

    public boolean deleteProject(int id) {
        return projectList.removeIf(p -> p.getId() == id);

    }
}
