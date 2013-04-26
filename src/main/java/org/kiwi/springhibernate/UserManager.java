package org.kiwi.springhibernate;

import java.util.*;

public class UserManager {
    private UserDAO userDAO;

    public UserManager() {
    }

    public UserManager(UserDAO userDao) {
        this.userDAO = userDao;
    }

    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId) > 0;
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
