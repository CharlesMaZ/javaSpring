package org.example;

public class Motorcycle extends Vehicle{
    private String kategoria;


    public Motorcycle(String brand, String model, int year, float price, boolean rented, String VIN, String rejestracja, String kategoria) {
        super(brand, model, year, price, rented, VIN, rejestracja);
        this.kategoria = kategoria;
    }

}
