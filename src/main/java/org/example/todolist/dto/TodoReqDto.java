package org.example.todolist.dto;

import lombok.Builder;
import org.example.todolist.model.Task;

import java.util.List;

@Builder
public class TodoReqDto {
    private String name;
    private List<Task> tasks;

}
