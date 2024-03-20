package org.example;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected float price;
    protected boolean rented;
    protected String VIN;
    protected String rejestracja;
    //protected String vehicleType;



    public Vehicle(String brand, String model, int year, float price, boolean rented, String VIN, String rejestracja) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = rented;
        this.VIN = VIN;
        this.rejestracja = rejestracja;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getRejestracja() {
        return rejestracja;
    }

    public void setRejestracja(String rejestracja) {
        this.rejestracja = rejestracja;
    }

//    public String getVehicleType() {
//        return vehicleType;
//    }
//
//    public void setVehicleType(String vehicleType) {
//        this.vehicleType = vehicleType;
//    }
    public String toCSV(){
        //return toCSV(brand, model, year, );
        return brand + "," + model + "," + year + "," + price + "," + rented + "," + VIN + "," + rejestracja;
    }
    public String toString(){
        //return toCSV(brand, model, year, );
        return brand + ", Model: " + model + ", Year: " + year + ", Price: " + price + ", Rented: " + rented + ", VIN: " + VIN + ", Rejestracja: " + rejestracja;
    }

}
