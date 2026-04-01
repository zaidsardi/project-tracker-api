package me.zaidsardi.projecttrackerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data @AllArgsConstructor @NoArgsConstructor
public class Project {
    private int id;
    private String title;
    private String techStack;
    private ProjectStatus status;


}
