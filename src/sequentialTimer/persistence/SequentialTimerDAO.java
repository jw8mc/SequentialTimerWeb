package sequentialTimer.persistence;

import org.apache.log4j.Logger;
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
public class SequentialTimerDAO {

    final static Logger logger = Logger.getLogger(SequentialTimerDAO.class);

    /**
     * Creates a new sequential_timers record based on the provided SequentialTimer entity
     * @param timer     a populated SequentialTimer object
     * @return Integer  the id of the newly created sequential_timers record
     */
    public Integer createSequentialTimer(SequentialTimer timer) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to create sequence timer.");
        Transaction tx = null;
        Integer timerId = null;

        try {
            tx = session.beginTransaction();
            timerId = (Integer)session.save(timer);
            tx.commit();
            logger.debug("New sequence timer committed.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to insert new sequence timer.");
            if (tx != null) {
                tx.rollback();
                logger.error("Rolling back sequence timer creation transaction.");
            }
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        return timerId;
    }

    /**
     * Retrieves all records from the sequential_timers table.
     * @return List<SequentialTimer>    a List of all records as SequentialTimer objects
     */
    public List<SequentialTimer> getAllSequentialTimers() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<SequentialTimer> timers = new ArrayList<SequentialTimer>();

        try {
            tx = session.beginTransaction();
            timers = session.createQuery("from SequentialTimer").list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        return timers;
    }

    /**
     * Retrieves a specific sequential_timers record with the provided id.
     * @param timerId   the id of the desired record
     * @return SequentialTimer  the retrieved record as an SequentialTimer object
     */
    public SequentialTimer getSequentialTimerById(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        SequentialTimer timer = null;

        try {
            tx = session.beginTransaction();
            String sql = "from SequentialTimer where id = :timerId";
            Query query = session.createQuery(sql);
            query.setInteger("timerId", timerId);
            timer = (SequentialTimer)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        return timer;
    }

    /**
     * Retrieves all timers owned by a given user.
     * @param userId    the id of the user
     * @return List<SequentialTimer>    a List of matching records as SequentialTimer objects
     */
    public List<SequentialTimer> getAllSequentialTimersForUser(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<SequentialTimer> timers = new ArrayList<SequentialTimer>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from SequentialTimer where ownerId = :ownerId");
            query.setInteger("ownerId", userId);
            timers = query.list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        return timers;
    }

    /**
     * Updates a given sequential_timers record with the data in the provided SequentialTimer object
     * @param timer     the SequentialTimer object to be updated
     */
    public void updateSequentialTimer(SequentialTimer timer) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(timer);
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }
    }

    /**
     * Deletes an sequential_timers record matching the given timer id.
     * @param timerId   the id of the record to be deleted
     */
    public void deleteSequentialTimer(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            SequentialTimer timer = (SequentialTimer)session.load(SequentialTimer.class, new Integer(timerId));
            session.delete(timer);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }
    }
}
