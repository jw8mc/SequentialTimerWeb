package sequentialTimer.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sequentialTimer.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jen on 11/4/2015.
 */
public class UserDAO {

    /**
     * Creates a new users record based on the provided User entity
     * @param user      a populated User object
     * @return Integer  the id of the newly created users record
     */
    public Integer createUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userId = null;

        try {
            tx = session.beginTransaction();
            userId = (Integer)session.save(user);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return userId;
    }

    /**
     * Retrieves all records from the users table
     * @return List<Users>  a List of all records as User objects
     */
    public List<User> getAllUsers() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<User> users = new ArrayList<User>();

        try {
            tx = session.beginTransaction();
            users = session.createQuery("from User").list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return users;
    }

    /**
     * Retrieves a specific user record with the provided id
     * @param userId    the id of the desired record
     * @return User     the retrieved record as a User object
     */
    public User getUserById(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;

        try {
            tx = session.beginTransaction();
            String sql = "from User where id = :userId";
            Query query = session.createQuery(sql);
            query.setInteger("userId", userId);
            user = (User)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    /**
     * Retrieves a specific user record with the provided username
     * @param username    the username of the desired record
     * @return User     the retrieved record as a User object
     */
    public User getUserByUsername(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;

        try {
            tx = session.beginTransaction();
            String sql = "from User where userName = :username";
            Query query = session.createQuery(sql);
            query.setParameter("username", username);
            user = (User)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    /**
     * Updates a given users record with the data from the provided User object
     * @param user  the User object to be updated
     */
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Deletes a users record matching the provided id
     * @param userId    the id of the record to be deleted
     */
    public void deleteUser(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = (User)session.load(User.class, new Integer(userId));
            session.delete(user);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
