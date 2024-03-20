package org.example;

public class User {
    private String login;
    private String password;
    private String role;
    private Vehicle vehicle;

    public User(String login, String password, String role, Vehicle vehicle) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.vehicle = vehicle;
    }

}
