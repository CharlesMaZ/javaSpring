package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository implements IVehicleRepository{
    private final List<Vehicle> vehicles;
    private String filePath;
    public VehicleRepository(String csvPath) {
        this.vehicles = new ArrayList<>();
        this.filePath = csvPath;
        loadFromCsv(filePath);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle rentCar(List<Vehicle> vehicles, String id) {
        for (Vehicle vehicle: vehicles) {
            if ( vehicle.rejestracja.equals(id)){
                if (vehicle.rented){
                    System.out.println("pojazd jest aktualnie wypożyczony, wybierz inny");
                }
                else {
                    vehicle.rented = true;
                    System.out.println("Pojazd: " + vehicle.model + " został przez Ciebie wypożyczony.");
                    saveToCSV();
                    return vehicle;
                }
            }
        }
        saveToCSV();
        return null;

    }

    @Override
    public boolean returnCar(List<Vehicle> vehicles, String id) {
        for (Vehicle vehicle: vehicles) {
            if (vehicle.rejestracja.equals(id)){
                if (!vehicle.rented){
                    System.out.println("samochodów nie jest wypożyczony, sprawdz cyz dobrze podałes id");
                }
                else {
                    vehicle.rented = false;
                    System.out.println("Pojazd " + vehicle.model +" został zwrócony");
                    saveToCSV();
                    return true;
                }
            }
        }
        saveToCSV();
        return false;
    }

    @Override
    public void saveToCSV(/*List<Vehicle> vehicles, File file*/) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (Vehicle vehicleObject: vehicles) {
                bufferedWriter.write(vehicleObject.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void loadFromCsv(String path){
        File fileCSV = new File(path);
        try (Scanner scanner = new Scanner(fileCSV)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] dataFromCsvLine = line.split(",");
                //System.out.println(dataFromCsvLine.length);
                //System.out.println(dataFromCsvLine[6]);
                if (dataFromCsvLine.length == 7 ){
                    //System.out.println(dataFromCsvLine[0] + dataFromCsvLine[5] + dataFromCsvLine[6]);

                    Car car = new Car(dataFromCsvLine[0], dataFromCsvLine[1], Integer.parseInt(dataFromCsvLine[2]), Float.parseFloat(dataFromCsvLine[3]), Boolean.parseBoolean(dataFromCsvLine[4]), dataFromCsvLine[5], dataFromCsvLine[6]);

                    vehicles.add(car);
                }
                else {
                    Motorcycle motorcycle = new Motorcycle(dataFromCsvLine[0], dataFromCsvLine[1], Integer.parseInt(dataFromCsvLine[2]), Float.parseFloat(dataFromCsvLine[3]), Boolean.parseBoolean(dataFromCsvLine[4]), dataFromCsvLine[5], dataFromCsvLine[6], dataFromCsvLine[7]); //tu się cos psuje, poza index wychodzi
                    //Motorcycle moro = new Motorcycle()
                    vehicles.add(motorcycle);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
            throw new RuntimeException(e);
        }
    }
}
