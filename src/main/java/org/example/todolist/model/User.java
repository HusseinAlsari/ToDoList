package org.example.todolist.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String uName;
    private String uPassword;
    private String uEmail;

    public User() {

    }
}
