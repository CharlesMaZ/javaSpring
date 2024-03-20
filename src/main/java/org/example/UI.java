package org.example;

import java.awt.*;
import java.util.Scanner;

public class UI {
    String filePath = "D:\\studia\\Spring\\rentCar\\src\\main\\java\\org\\example\\vehicles.csv";
    private VehicleRepository vehicleRepository = new VehicleRepository(filePath);
    public void menu() {
        while (true) {
            System.out.println("Witamy w wypożyczalni");
            System.out.println("1. Wypożycz auto \n 2.Zwróć auto");
            Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();
            //stworzyc oniekt wypozyczonego pojazdu

            if (wybor == 1) {
                System.out.println("Baza samochodów");
                System.out.println(vehicleRepository.getVehicles());
                scanner.nextLine();

                System.out.println("Podaj rejestracje samochodu do wypożyczenia");
                String carId = scanner.nextLine();
                Vehicle rentVehicle = vehicleRepository.rentCar(vehicleRepository.getVehicles(), carId);


            } else if (wybor == 2) {
                scanner.nextLine();
                System.out.println("Podaj rejestracje samochodu do zwrocenia");
                String carId = scanner.nextLine();
                vehicleRepository.returnCar(vehicleRepository.getVehicles(), carId);
            }
        }
    }
}
