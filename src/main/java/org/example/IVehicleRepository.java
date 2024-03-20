package org.example;

import java.io.File;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> getVehicles();
    Vehicle rentCar(List<Vehicle> vehicles, String id);
    boolean returnCar(List<Vehicle> vehicles, String id);
    void saveToCSV(/*List<Vehicle> vehicles, File file*/);

    void addVehicle(Vehicle vehicle);
    void removeVehicle(Vehicle vehicle);



}
