package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Jeff", "Bezos", (byte) 57);
        userService.saveUser("Mark", "Zuckerberg", (byte) 37);
        userService.saveUser("Pavel", "Durov", (byte) 37);
        userService.saveUser("Alisher", "Morgenshtern", (byte) 23);
        List<User> userList = userService.getAllUsers();
        for (User value : userList) {
            System.out.println(value.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
