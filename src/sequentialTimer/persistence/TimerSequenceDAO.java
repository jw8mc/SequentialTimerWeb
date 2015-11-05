package sequentialTimer.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sequentialTimer.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jen on 11/5/2015.
 */
public class TimerSequenceDAO {

    /**
     * Creates a new timer_sequences record based on the provided TimerSequence entity
     * @param ts      a populated TimerSequence object
     * @return Integer  the id of the newly created timer_sequences record
     */
    public Integer createTimerSequence(TimerSequence ts) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer tsId = null;

        try {
            tx = session.beginTransaction();
            tsId = (Integer)session.save(ts);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return tsId;
    }

    /**
     * Retrieves all records from the timer_sequences table
     * @return List<TimerSequence>  a List of all records as TimerSequence objects
     */
    public List<TimerSequence> getAllTimerSequences() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<TimerSequence> timerSequences = new ArrayList<TimerSequence>();

        try {
            tx = session.beginTransaction();
            timerSequences = session.createQuery("from timer_sequences").list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return timerSequences;
    }

    /**
     * Retrieves a specific timer_sequences record with the provided id
     * @param tsId    the id of the desired record
     * @return TimerSequence     the retrieved record as a TimerSequence object
     */
    public TimerSequence getTimerSequenceById(int tsId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        TimerSequence ts = null;

        try {
            tx = session.beginTransaction();
            String sql = "from timer_sequence where id = :tsId";
            Query query = session.createQuery(sql);
            query.setInteger("tsId", tsId);
            ts = (TimerSequence)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return ts;
    }

    /**
     * Retrieves all timer_sequences records containing a given anchor timer id.
     * @param timerId    the id of the anchor timer
     * @return List<TimerSequence>    a List of matching records as TimerSequence objects
     */
    public List<TimerSequence> getAllTimerSequencesForAnchorTimer(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<TimerSequence> ts = new ArrayList<TimerSequence>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from timer_sequences where anchor_timer_id = :timerId");
            query.setInteger("timerId", timerId);
            ts = query.list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return ts;
    }

    /**
     * Retrieves all timers owned by a given user.
     * @param userId    the id of the user
     * @return List<TimerSequence>    a List of matching records as TimerSequence objects
     */
    public List<TimerSequence> getAllTimerSequencesForUser(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<TimerSequence> timerSequences = new ArrayList<TimerSequence>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from timer_sequences where ownerId = :ownerId");
            query.setInteger("ownerId", userId);
            timerSequences = query.list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return timerSequences;
    }

    /**
     * Updates a given timer_sequences record with the data from the provided TimerSequence object
     * @param ts  the TimerSequence object to be updated
     */
    public void updateTimerSequence(TimerSequence ts) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(ts);
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Deletes a timer_sequences record matching the provided id
     * @param tsId    the id of the record to be deleted
     */
    public void deleteTimerSequence(int tsId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            TimerSequence ts = (TimerSequence)session.load(TimerSequence.class, new Integer(tsId));
            session.delete(ts);
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
