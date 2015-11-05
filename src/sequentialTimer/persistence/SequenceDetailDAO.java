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
public class SequenceDetailDAO {

    /**
     * Creates a new sequence_details record based on the provided SequenceDetail entity
     * @param sDetail      a populated SequenceDetail object
     * @return Integer  the id of the newly created sequence_details record
     */
    public Integer createSequenceDetail(SequenceDetail sDetail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer sDetailId = null;

        try {
            tx = session.beginTransaction();
            sDetailId = (Integer)session.save(sDetail);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return sDetailId;
    }

    /**
     * Retrieves all records from the sequence_details table
     * @return List<SequenceDetail>  a List of all records as SequenceDetail objects
     */
    public List<SequenceDetail> getAllSequenceDetails() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<SequenceDetail> sDetails = new ArrayList<SequenceDetail>();

        try {
            tx = session.beginTransaction();
            sDetails = session.createQuery("from sequence_details").list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return sDetails;
    }

    /**
     * Retrieves a specific sequence_details record with the provided id
     * @param sDetailId    the id of the desired record
     * @return SequenceDetail     the retrieved record as a SequenceDetail object
     */
    public SequenceDetail getSequenceDetailById(int sDetailId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        SequenceDetail sDetail = null;

        try {
            tx = session.beginTransaction();
            String sql = "from sequence_details where id = :sDetailId";
            Query query = session.createQuery(sql);
            query.setInteger("sDetailId", sDetailId);
            sDetail = (SequenceDetail)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return sDetail;
    }

    /**
     * Retrieves all sequence details containing a given sequential timer id.
     * @param timerId    the id of the sequential timer
     * @return List<SequenceDetail>    a List of matching records as SequenceDetail objects
     */
    public List<SequenceDetail> getAllSequenceDetailsForSequentialTimer(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<SequenceDetail> sDetails = new ArrayList<SequenceDetail>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from sequence_details where sequential_timer_id = :timerId");
            query.setInteger("timerId", timerId);
            sDetails = query.list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return sDetails;
    }

    /**
     * Retrieves all sequence details containing a given timer sequence id.
     * This method will be used to populate the timer_sequences number_of_timers field
     * @param sequenceId    the id of the sequential timer
     * @return List<SequenceDetail>    a List of matching records as SequenceDetail objects
     */
    public List<SequenceDetail> getAllSequenceDetailsForTimerSequence(int sequenceId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<SequenceDetail> sDetails = new ArrayList<SequenceDetail>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from sequence_details where timer_sequence_id = :sequenceId");
            query.setInteger("sequenceId", sequenceId);
            sDetails = query.list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return sDetails;
    }

    /**
     * Updates a given sequence_details record with the data from the provided SequenceDetail object
     * @param sDetail  the SequenceDetail object to be updated
     */
    public void updateSequenceDetail(SequenceDetail sDetail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(sDetail);
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Deletes a sequence_details record matching the provided id
     * @param sDetailId    the id of the record to be deleted
     */
    public void deleteSequenceDetail(int sDetailId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            SequenceDetail sDetail = (SequenceDetail)session.load(SequenceDetail.class, new Integer(sDetailId));
            session.delete(sDetail);
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
