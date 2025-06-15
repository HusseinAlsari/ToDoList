package org.example.todolist.model;
import java.util.UUID;

public class User {
    private String uName;
    private String uPassword;
    private String uEmail;
    private String id;

    public User(String uName, String uPassword, String uEmail, int id) {
        this.uName = uName;
        this.uPassword = uPassword;
        this.uEmail = uEmail;
        this.id = UUID.randomUUID().toString();
    }

    public String getuName() {
        return uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public String getuEmail() {
        return uEmail;
    }

    public String getId() {
        return id;
    }


    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
