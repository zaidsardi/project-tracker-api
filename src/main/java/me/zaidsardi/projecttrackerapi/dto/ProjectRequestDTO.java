package me.zaidsardi.projecttrackerapi.dto;

import me.zaidsardi.projecttrackerapi.model.ProjectStatus;

public record ProjectRequestDTO(String title, String techStack, ProjectStatus status){}