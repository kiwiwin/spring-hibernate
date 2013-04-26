package org.kiwi.springhibernate;

import org.springframework.transaction.annotation.*;

import java.util.*;

public class UserManager {
    private UserDAO userDAO;

    public UserManager() {
    }

    public UserManager(UserDAO userDao) {
        this.userDAO = userDao;
    }

    @Transactional
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Transactional
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Transactional
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Transactional
    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId) > 0;
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
