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
public class AnchorTimerDAO {

    /**
     * Creates a new anchor_timers record based on the provided AnchorTimer entity
     * @param timer     a populated AnchorTimer object
     * @return Integer  the id of the newly created anchor_timers record
     */
    public Integer createAnchorTimer(AnchorTimer timer) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer timerId = null;

        try {
            tx = session.beginTransaction();
            timerId = (Integer)session.save(timer);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return timerId;
    }

    /**
     * Retrieves all records from the anchor_timers table.
     * @return List<AnchorTimer>    a List of all records as AnchorTimer objects
     */
    public List<AnchorTimer> getAllAnchorTimers() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<AnchorTimer> timers = new ArrayList<AnchorTimer>();

        try {
            tx = session.beginTransaction();
            timers = session.createQuery("from anchor_timers").list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return timers;
    }

    /**
     * Retrieves a specific anchor_timers record with the provided id.
     * @param timerId   the id of the desired record
     * @return AnchorTimer  the retrieved record as an AnchorTimer object
     */
    public AnchorTimer getAnchorTimerById(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        AnchorTimer timer = null;

        try {
            tx = session.beginTransaction();
            String sql = "from anchor_timers where id = :timerId";
            Query query = session.createQuery(sql);
            query.setInteger("timerId", timerId);
            timer = (AnchorTimer)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return timer;
    }

    /**
     * Retrieves all timers owned by a given user.
     * @param userId    the id of the user
     * @return List<AnchorTimer>    a List of matching records as AnchorTimer objects
     */
    public List<AnchorTimer> getAllAnchorTimersForUser(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<AnchorTimer> timers = new ArrayList<AnchorTimer>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from anchor_timers where ownerId = :ownerId");
            query.setInteger("ownerId", userId);
            timers = query.list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return timers;
    }

    /**
     * Updates a given anchor_timers record with the data in the provided AnchorTimer object
     * @param timer     the AnchorTimer object to be updated
     */
    public void updateAnchorTimer(AnchorTimer timer) {
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
        }
    }

    /**
     * Deletes an anchor_timers record matching the given timer id.
     * @param timerId   the id of the record to be deleted
     */
    public void deleteAnchorTimer(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            AnchorTimer timer = (AnchorTimer)session.load(AnchorTimer.class, new Integer(timerId));
            session.delete(timer);
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
