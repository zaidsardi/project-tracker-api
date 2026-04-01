package me.zaidsardi.projecttrackerapi.controller;

import me.zaidsardi.projecttrackerapi.model.ProjectStatus;
import me.zaidsardi.projecttrackerapi.model.Project;
import me.zaidsardi.projecttrackerapi.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectService service;
    public ProjectController(ProjectService service) {
        this.service = service;
    }
    @GetMapping
    public List<Project> getProjects(){
        return service.getProjects();
    }
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable int id){
        return service.getProjectById(id);
    }
    @PostMapping
    public Project addProject(@RequestBody Project project){
        return service.addProject(project);
    }
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable int id,@RequestBody Project project){
        return service.updateProject(id,project);
    }
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id){
         service.deleteProject(id);
    }
}
