package org.kiwi.springhibernate;

import org.springframework.context.*;
import org.springframework.context.support.*;

import java.util.*;

public class UserApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-config.xml");
        UserManager userManager = (UserManager) context.getBean("userManager");
        //Before insert a user
        listUsers(userManager);
        //insert a user
        User newUser = new User();
        newUser.setUsername("hehe zhang");
        newUser.setAge(19);
        userManager.insertUser(newUser);
        //after insert a user
        listUsers(userManager);
        //delete a user
        userManager.deleteUser(newUser.getId());
        //after delete the new user
        listUsers(userManager);
        //update rocojie age
        User user = userManager.getUser("rocojie");
        user.setAge(20);
        userManager.updateUser(user);
        //after update
        listUsers(userManager);
    }

    private static void listUsers(UserManager userManager) {
        List<User> users = userManager.getUsers();
        System.out.println(String.format("User Count: %d", users.size()));
        for (User user : users) {
            System.out.println(user.display());
        }
    }
}
