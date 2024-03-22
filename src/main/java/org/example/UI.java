package org.example;

import java.awt.*;
import java.util.Scanner;

public class UI {
    String filePath = "D:\\studia\\Spring\\rentCar\\src\\main\\java\\org\\example\\vehicles.csv";
    private VehicleRepository vehicleRepository = new VehicleRepository(filePath);
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWitamy w wypożyczalni");
        System.out.println("--LOGOWANIE--\nPodaj login:");
        String login = scanner.nextLine();
        System.out.println("Poddaj hasło:");
        ////
        //### dodac ifa albo dwie klasy który pokaże że zalgowano jako admin/user i da menu zależne od uprawnień
        ////
        while (true) {
            //zrobić logowanie,  tylko admin może dodawać i usuwać samochody
            //admin może przeglądać listy userów i inne szczególy
            //może dwie klasy menu jedna dla admin druga dla user?

            System.out.println("\n1.Wypożycz auto \n2.Zwróć auto\n3.Wyjdź");
            //Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();
            //stworzyc oniekt wypozyczonego pojazdu

            if (wybor == 1) {
                System.out.println("Baza samochodów:");
                for (Vehicle vehicle : vehicleRepository.getVehicles()) {
                    System.out.println(vehicle.toString());
                    //System.out.println("");
                }
                System.out.println("");
                //System.out.println(vehicleRepository.getVehicles());
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
            else {
                System.out.println("Do zobaczenia!");
                System.exit(0);
            }
        }
    }
}
