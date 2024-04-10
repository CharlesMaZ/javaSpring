package org.example;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, InvalidPasswordException {
        System.out.println("Start");

        App app = new App();
        app.menu();
        System.out.println("po wywolaniu app!");
    }
}