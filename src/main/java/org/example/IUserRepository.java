package org.example;

import java.util.List;

public interface IUserRepository {
    List<User> getUser();
    List<User> getUsers();
    void save();
}
