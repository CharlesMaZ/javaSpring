package org.example;

import java.util.Scanner;

public class App {
    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\vehicles.csv";
    String usersPath = System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\users.csv";
    private VehicleRepository vehicleRepository = new VehicleRepository(filePath);
    //a moze bieżaco przesuzkiwać csv?Wydajnosc pamieciowa przy dużym csv
    private UserRepository userRepository = new UserRepository(usersPath);

    public void menu() throws UserNotFoundException, InvalidPasswordException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWitamy w wypożyczalni");
        System.out.println("--LOGOWANIE--\nPodaj login:");
        String login = scanner.nextLine();
        System.out.println("Poddaj hasło:");

        //haslo user - user123, admin - admin123

        String passHas = PasswordHasher.hashPassword(scanner.nextLine());
        User user = Authentication.login(login, passHas, userRepository.getUsers()); //pytanie czy lepiej by Authentication trzymała usera i zwrać się przez pośrednictwo Authenticaton czy trzymac usera w tej klasie?

        if (user.getRole().equals("user")) {
            System.out.println("zalogowano jako użytkownik");
            while (true) {
                userMenu(user);
            }
        } else if (user.getRole().equals("admin")) {
            System.out.println("zalogowano jako admin");
            while (true) {
                adminMenu(user);
            }
        }
    }

    public void userMenu(User user) {
        System.out.println("\n1.Wypożycz auto \n2.Zwróć auto\n3.Wyjdź");
        Scanner scanner = new Scanner(System.in);
        int wybor = Integer.parseInt(scanner.nextLine());
        String carId = null;

        switch (wybor) {
            case 1:
                System.out.println("Baza samochodów:");
                for (Vehicle vehicle : vehicleRepository.getVehicles()) {
                    System.out.println(vehicle.toString());
                    //System.out.println("");
                }

                System.out.println("Podaj rejestracje samochodu do wypożyczenia");
                String carID = scanner.nextLine();
                //user.setVehicleID(scanner.nextLine());
                Vehicle rentedVehicle = vehicleRepository.rentCar(vehicleRepository.getVehicles(), carID); //przekazać całegp usera?
                user.setVehicleID(rentedVehicle.rejestracja);
                //userRepository.save(); // dokończyć by nie waliło błędami po wyjsciu z programu było w csv info o wypozczyonym samochodzie
                break;

            case 2:
                if (user.getVehicleID() != null) {
                    vehicleRepository.returnCar(vehicleRepository.getVehicles(), user.getVehicleID());
                    user.setVehicleID(null);

                } else {
                    System.out.println("nie masz wypożyczonego samochodu");
                }
                break;
            case 3:
                System.out.println("Do zobaczenia!");
                System.exit(0);

        }
    }

    public void adminMenu(User user) {
        System.out.println("\n1.Wypożycz auto \n2.Zwróć auto\n3.Dodaj car\n4. Dodaj motorcycle\n5. Usuń pojazd\n6. Lista userów\n7.Lista pojazdów\n8.Wyjdź");
        Scanner scanner = new Scanner(System.in);
        int wybor = Integer.parseInt(scanner.nextLine());
        //String carId = null;
        //Vehicle rentedVehicle;

        switch (wybor) {
            case 1:
                System.out.println("Baza samochodów:");
                for (Vehicle vehicle : vehicleRepository.getVehicles()) {
                    System.out.println(vehicle.toString());
                    //System.out.println("");
                }

                System.out.println("Podaj rejestracje samochodu do wypożyczenia");
                user.setVehicleID(scanner.nextLine());
                //rentedVehicle = vehicleRepository.rentCar(vehicleRepository.getVehicles(), carId);
                break;

            case 2:
                if (user.getVehicleID() != null) {
                    vehicleRepository.returnCar(vehicleRepository.getVehicles(), user.getVehicleID());
                    user.setVehicleID(null);

                } else {
                    System.out.println("nie masz wypożyczonego samochodu");
                }
                break;

            case 3:
                System.out.println("Podaj brand");
                String brand = scanner.nextLine();

                System.out.println("Podaj model");
                String model = scanner.nextLine();

                System.out.println("Podaj year");
                int year = Integer.parseInt(scanner.nextLine());

                System.out.println("Podaj price");
                float price = Float.parseFloat(scanner.nextLine());

                System.out.println("Podaj VIN");
                String VIN = scanner.nextLine();

                System.out.println("Podaj rejestracje");
                String rejestracja = scanner.nextLine();

                Vehicle newVehicle = new Car(brand, model,year,price,false, VIN,rejestracja);
                vehicleRepository.addVehicle(newVehicle);
                break;

            case 4:
                System.out.println("Podaj brand");
                String mbrand = scanner.nextLine();

                System.out.println("Podaj model");
                String mmodel = scanner.nextLine();

                System.out.println("Podaj year");
                int myear = Integer.parseInt(scanner.nextLine());

                System.out.println("Podaj price");
                float mprice = Float.parseFloat(scanner.nextLine());

                System.out.println("Podaj VIN");
                String mVIN = scanner.nextLine();

                System.out.println("Podaj rejestracje");
                String mrejestracja = scanner.nextLine();

                System.out.println("Podaj kategorię");
                String kat = scanner.nextLine();

                Vehicle mnewVehicle = new Motorcycle(mbrand, mmodel,myear,mprice,false, mVIN,mrejestracja,kat);
                vehicleRepository.addVehicle(mnewVehicle);
                break;

            case 5:
                System.out.println("Podaj rejestrację pojazdu do usuniecia:");
                String rej = scanner.nextLine();
                vehicleRepository.removeVehicle(rej);
                break;
            case 6:
                System.out.println(userRepository);
                break;
            case 7:
                System.out.println(vehicleRepository);
                break;

            case 8:
                System.out.println("Do zobaczenia!");
                System.exit(0);
        }
    }

}
