package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    private final List<User> usersList;
    private String fileUsersPath;

    public UserRepository(String fileUsersPath) {
        this.usersList = new ArrayList<>();
        this.fileUsersPath = fileUsersPath;
        //load from csv
    }
    @Override
    public List<User> getUser() {
        return usersList;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void save(/*List<Vehicle> vehicles, File file*/) {
        File file = new File(fileUsersPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (User user: usersList) {
                //bufferedWriter.write(user.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
