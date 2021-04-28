package org.example.web.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    private  int id;
    @NotEmpty(message = "Username should not be  empty")
    @Size(min =2, max =30, message = "Size should be between 2 and 30 characters")
    private String username;
    @NotEmpty(message = "Password should not be  empty")
    private String password;

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
