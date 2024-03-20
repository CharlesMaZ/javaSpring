package org.example;

import java.util.List;

public interface IUserRepository {
    User getUser();
    List<User> getUsers();
    void save();
}
