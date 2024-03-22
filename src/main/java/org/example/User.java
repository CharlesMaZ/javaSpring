package org.example;

public class User {
    private String login;
    private String password;
    private String role;

    private String vehicleID;  //private Vehicle vehicle; chyba lepiej string, bo tak będzie w csv


    public User(String login, String password, String role, String vehicleID) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.vehicleID = vehicleID;//this.vehicle = vehicle;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
}
