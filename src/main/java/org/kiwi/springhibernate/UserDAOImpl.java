package org.kiwi.springhibernate;

import org.hibernate.*;

import java.util.*;

public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertUser(User user) {
        currentSession().save(user);
    }

    @Override
    public User getUserById(int userId) {
        return (User) currentSession()
                .get(User.class, userId);
    }

    @Override
    public User getUser(String username) {
        return (User) currentSession()
                .createQuery("from User where username = :username")
                .setParameter("username", username)
                .list().get(0);
    }

    @Override
    public List<User> getUsers() {
        return currentSession()
                .createCriteria(User.class)
                .list();
    }

    @Override
    public int deleteUser(int userId) {
        return currentSession().createQuery("delete from User where id = :id")
                .setParameter("id", userId)
                .executeUpdate();
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void updateUser(User user) {
        currentSession().saveOrUpdate(user);
    }
}
