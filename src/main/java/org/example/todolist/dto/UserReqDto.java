package org.example.todolist.dto;

import lombok.Builder;

@Builder
public class UserReqDto {
    private String username;
    private String password;
}
