package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.HibernateConnect().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS `user` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastname` VARCHAR(45) NULL,\n" +
                "  `age` INT NULL,\n" +
                "  PRIMARY KEY (`id`));").executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.HibernateConnect().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS user").executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.HibernateConnect().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = new User(name, lastName, age);
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.HibernateConnect().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        String query = "FROM User";
        TypedQuery<User> typedQuery = Util.HibernateConnect().openSession().createQuery(query, User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.HibernateConnect().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createSQLQuery("TRUNCATE user").executeUpdate();
        tx1.commit();
        session.close();
    }
}
