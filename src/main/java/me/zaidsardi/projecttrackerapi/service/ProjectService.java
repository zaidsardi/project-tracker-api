package me.zaidsardi.projecttrackerapi.service;

import me.zaidsardi.projecttrackerapi.model.ProjectStatus;
import me.zaidsardi.projecttrackerapi.model.Project;
import me.zaidsardi.projecttrackerapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProjectService {
//    private List<Project> projectList = new ArrayList<>(Arrays.asList(
//            new Project(101,"Clinic Appointment API","Spring-boot", ProjectStatus.IN_PROGRESS),
//            new Project(102,"Task Tracker API","Node.js",ProjectStatus.PLANNED),
//            new Project(103,"Portfolio ","HTML/CSS/JavaScript",ProjectStatus.COMPLETED)
//    ));
ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
            return projectRepository.findAll();
    }
    public Project getProjectById(int id) {
        return projectRepository.findById(id).orElse(new Project());
    }
    public Project addProject(Project project) {
          projectRepository.save(project);
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
