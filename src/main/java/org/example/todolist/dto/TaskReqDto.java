package org.example.todolist.dto;

import lombok.Builder;

@Builder
public class TaskReqDto {
    private String title;
    private String description;
    private String priority;
}
