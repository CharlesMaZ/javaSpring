package org.example;

public class Car extends Vehicle {


    public Car(String brand, String model, int year, float price, boolean rented, String VIN, String rejestracja) {
        super(brand, model, year, price, rented, VIN, rejestracja);
        //vehicleType = "car";
    }
    public String toCSV(){
        //return toCSV(brand, model, year, );
        return brand + "," + model + "," + year + "," + price + "," + rented + "," + VIN + "," + rejestracja;
    }
}
