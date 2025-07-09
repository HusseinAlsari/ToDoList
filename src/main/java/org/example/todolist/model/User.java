package org.example.todolist.model;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;


    public User(String username, String password,String email) {
        this.username = username;
        this.password=password;
        this.email=email;
    }
}
