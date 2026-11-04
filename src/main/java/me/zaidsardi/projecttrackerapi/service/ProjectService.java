package me.zaidsardi.projecttrackerapi.service;

import me.zaidsardi.projecttrackerapi.dto.ProjectResponseDTO;
import me.zaidsardi.projecttrackerapi.excption.ResourceNotFoundException;
import me.zaidsardi.projecttrackerapi.mapper.ProjectMapper;
import me.zaidsardi.projecttrackerapi.model.Project;
import me.zaidsardi.projecttrackerapi.dto.ProjectRequestDTO;
import me.zaidsardi.projecttrackerapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    final ProjectRepository projectRepository;
    final ProjectMapper mapper;
    public ProjectService(ProjectRepository projectRepository, ProjectMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }

    public List<ProjectResponseDTO> getProjects() {
             return projectRepository.findAll()
                     .stream().map(mapper::toDTO)
                     .toList();
    }

    public ProjectResponseDTO getProjectById(int id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("project not found"));
        return mapper.toDTO(project);
    }

    public ProjectResponseDTO addProject(ProjectRequestDTO requestDTO) {
        Project entity = mapper.toEntity(requestDTO);
        Project savedEntity = projectRepository.save(entity);
         return mapper.toDTO(savedEntity);
    }

    public ProjectResponseDTO updateProject(int id, ProjectRequestDTO requestDTO) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("project not found"));
        existingProject.setTitle(requestDTO.title());
        existingProject.setTechStack(requestDTO.techStack());
        existingProject.setStatus(requestDTO.status());
        return mapper.toDTO(projectRepository.save(existingProject));
    }

    public void deleteProject(int id) {
         projectRepository.deleteById(id);
    }

    public List<ProjectResponseDTO> searchProjects(String title) {
        return projectRepository.searchProjects(title)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
