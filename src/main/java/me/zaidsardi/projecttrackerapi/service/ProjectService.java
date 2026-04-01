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
        Project existingProject;
        if (projectRepository.findById(id).isPresent()){
            existingProject = projectRepository.findById(id).get();
            existingProject.setTitle(updatedProject.getTitle());
            existingProject.setStatus(updatedProject.getStatus());
            existingProject.setTechStack(updatedProject.getTechStack());
            return projectRepository.save(existingProject);
        }
        else
            return null;
    }

    public void deleteProject(int id) {
         projectRepository.deleteById(id);
    }


}
