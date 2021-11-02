package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl temp = new UserDaoJDBCImpl();
        temp.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl temp = new UserDaoJDBCImpl();
        temp.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl temp = new UserDaoJDBCImpl();
        temp.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl temp = new UserDaoJDBCImpl();
        temp.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl temp = new UserDaoJDBCImpl();
        return temp.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl temp = new UserDaoJDBCImpl();
        temp.cleanUsersTable();
    }
}
