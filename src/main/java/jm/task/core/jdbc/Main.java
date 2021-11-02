package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Jeff", "Bezos", (byte) 57);
        user.saveUser("Mark", "Zuckerberg", (byte) 37);
        user.saveUser("Pavel", "Durov", (byte) 37);
        user.saveUser("Alisher", "Morgenshtern", (byte) 23);
        List<User> userList = user.getAllUsers();
        for (User value : userList) {
            System.out.println(value.toString());
        }
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
