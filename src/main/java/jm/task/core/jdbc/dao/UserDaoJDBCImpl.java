package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.DbConnect(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS `user` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastname` VARCHAR(45) NULL,\n" +
                    "  `age` INT NULL,\n" +
                    "  PRIMARY KEY (`id`));");
            Util.DbCloseConnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.DbConnect(); Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS user");
            Util.DbCloseConnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.DbConnect(); Statement statement = connection.createStatement()) {
            String sql = new StringBuilder().append("INSERT INTO USER (name, lastname, age) VALUES('").append(name)
                    .append("', '").append(lastName).append("', ").append(age).append(");").toString();
            statement.execute(sql);
            System.out.printf("User с именем – %s %s добавлен в базу данных \n", name, lastName);
            Util.DbCloseConnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.DbConnect(); Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM user WHERE ID = " + id + ";";
            statement.execute(sql);
            Util.DbCloseConnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        User user;
        try (Connection connection = Util.DbConnect(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                result.add(user);
            }
            Util.DbCloseConnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.DbConnect(); Statement statement = connection.createStatement()) {
            String sql = "TRUNCATE USER";
            statement.execute(sql);
            Util.DbCloseConnect(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
