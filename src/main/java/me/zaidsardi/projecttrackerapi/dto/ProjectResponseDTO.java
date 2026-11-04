package me.zaidsardi.projecttrackerapi.dto;


import me.zaidsardi.projecttrackerapi.model.ProjectStatus;


public record ProjectResponseDTO(Integer id, String title, String techStack, ProjectStatus status){}