package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements IUserRepository{
    private final List<User> users;
    private final String fileUsersPath;

    public UserRepository(String fileUsersPath) {
        this.users = new ArrayList<>();
        this.fileUsersPath = fileUsersPath;
        loadUsersFromCsv(fileUsersPath);
    }
    @Override
    public User getUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return user;
            }
            else {
                System.out.println("Nie znaleziono usera!");
                return null; // zwrócić wyjątek
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void save(/*List<Vehicle> vehicles, File file*/) {
        File file = new File(fileUsersPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (User user: users) {
                //bufferedWriter.write(user.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadUsersFromCsv(String path){ //skopiowane z vehicles, porpawić na users
        File fileCSV = new File(path);
        try (Scanner scanner = new Scanner(fileCSV)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] dataFromCsvLine = line.split(",");

                User user = new User(dataFromCsvLine[0], dataFromCsvLine[1], dataFromCsvLine[2], dataFromCsvLine[3]);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
            throw new RuntimeException(e);
        }
    }
}
