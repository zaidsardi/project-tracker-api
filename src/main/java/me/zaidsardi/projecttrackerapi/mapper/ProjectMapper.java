package me.zaidsardi.projecttrackerapi.mapper;

import me.zaidsardi.projecttrackerapi.dto.ProjectRequestDTO;
import me.zaidsardi.projecttrackerapi.dto.ProjectResponseDTO;
import me.zaidsardi.projecttrackerapi.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectResponseDTO toDTO(Project project){
         return new ProjectResponseDTO(project.getId(),project.getTitle(), project.getTechStack(),project.getStatus());
    }
    public Project toEntity(ProjectRequestDTO requestDTO){
        Project project = new Project();
        project.setTitle(requestDTO.title());
        project.setStatus(requestDTO.status());
        project.setTechStack(requestDTO.techStack());
        return project;
    }
}
