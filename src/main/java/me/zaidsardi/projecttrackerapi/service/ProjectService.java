package me.zaidsardi.projecttrackerapi.service;

import me.zaidsardi.projecttrackerapi.excption.ResourceNotFoundException;
import me.zaidsardi.projecttrackerapi.model.Project;
import me.zaidsardi.projecttrackerapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {
    final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
            return projectRepository.findAll();
    }
    public Project getProjectById(int id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("project not found"));
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


    public List<Project> searchProjects(String title) {
        return projectRepository.searchProjects(title);
    }
}
