package me.zaidsardi.projecttrackerapi.controller;

import me.zaidsardi.projecttrackerapi.dto.ProjectRequestDTO;
import me.zaidsardi.projecttrackerapi.dto.ProjectResponseDTO;
import me.zaidsardi.projecttrackerapi.model.Project;
import me.zaidsardi.projecttrackerapi.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectService service;
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProjectResponseDTO> getProjects(){
        return service.getProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(@PathVariable int id){
        return service.getProjectById(id);
    }

    @GetMapping("/search")
    public List<ProjectResponseDTO> searchProjects(@RequestParam String title){
        return service.searchProjects(title);
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDTO addProject(@RequestBody ProjectRequestDTO requestDTO){
        return service.addProject(requestDTO);
    }

    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject(@PathVariable int id,@RequestBody ProjectRequestDTO requestDTO){
        return service.updateProject(id, requestDTO);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable int id){
         service.deleteProject(id);
    }

}
