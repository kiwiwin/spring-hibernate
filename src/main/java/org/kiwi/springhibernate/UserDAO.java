package org.kiwi.springhibernate;

import java.util.*;

public interface UserDAO {
    void insertUser(User user);

    User getUserById(int userId);

    User getUser(String username);

    List<User> getUsers();

    int deleteUser(int userId);

    void updateUser(User user);
}
