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
public class SequenceDetailDAO {

    final static Logger logger = Logger.getLogger(SequenceDetailDAO.class);

    /**
     * Creates a new sequence_details record based on the provided SequenceDetail entity
     * @param sDetail      a populated SequenceDetail object
     * @return Integer  the id of the newly created sequence_details record
     */
    public Integer createSequenceDetail(SequenceDetail sDetail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to create sequence detail.");
        Transaction tx = null;
        Integer sDetailId = null;

        try {
            tx = session.beginTransaction();
            sDetailId = (Integer)session.save(sDetail);
            tx.commit();
            logger.debug("New sequence committed.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to insert new sequence detail.");
            if (tx != null) {
                tx.rollback();
                logger.error("Rolling back sequence detail creation transaction.");
            }
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        logger.info("New sequence detail ID: " + sDetailId);
        return sDetailId;
    }

    /**
     * Retrieves all records from the sequence_details table
     * @return List<SequenceDetail>  a List of all records as SequenceDetail objects
     */
    public List<SequenceDetail> getAllSequenceDetails() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to get all sequence details.");
        Transaction tx = null;
        List<SequenceDetail> sDetails = new ArrayList<SequenceDetail>();

        try {
            tx = session.beginTransaction();
            sDetails = session.createQuery("from SequenceDetail").list();
            logger.debug("All sequence details retrieved.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to retrieve all sequence detail records.");
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        logger.info("Sequence details retrieved: " + sDetails);
        return sDetails;
    }

    /**
     * Retrieves a specific sequence_details record with the provided id
     * @param sDetailId    the id of the desired record
     * @return SequenceDetail     the retrieved record as a SequenceDetail object
     */
    public SequenceDetail getSequenceDetailById(int sDetailId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to retrieve sequence detail.");
        Transaction tx = null;
        SequenceDetail sDetail = null;

        try {
            tx = session.beginTransaction();
            String sql = "from SequenceDetail where id = :sDetailId";
            Query query = session.createQuery(sql);
            query.setInteger("sDetailId", sDetailId);
            sDetail = (SequenceDetail)query.uniqueResult();
            logger.debug("Sequence detail record retrieved.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to retrieve single sequence detail.");
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        logger.info("Sequence detail retrieved: " + sDetail);
        return sDetail;
    }

    /**
     * Retrieves all sequence details containing a given sequential timer id.
     * @param timerId    the id of the sequential timer
     * @return List<SequenceDetail>    a List of matching records as SequenceDetail objects
     */
    public List<SequenceDetail> getAllSequenceDetailsForSequentialTimer(int timerId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to get all sequence details for a single timer.");
        Transaction tx = null;
        List<SequenceDetail> sDetails = new ArrayList<SequenceDetail>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from SequenceDetail where sequentialTimerId = :timerId");
            query.setInteger("timerId", timerId);
            sDetails = query.list();
            logger.debug("Sequence details records retrieved.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to retrieve timer sequence details for given timer.");
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        logger.info("Sequence details retrieved: " + sDetails);
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
        logger.debug("Session opened to get all sequence details for a given sequence.");
        Transaction tx = null;
        List<SequenceDetail> sDetails = new ArrayList<SequenceDetail>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from SequenceDetail where timerSequenceId = :sequenceId");
            query.setInteger("sequenceId", sequenceId);
            sDetails = query.list();
            logger.debug("Sequence details retrieved.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to retrieve sequence details for a given sequence.");
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }

        logger.info("Sequence details retrieved: " + sDetails);
        return sDetails;
    }

    /**
     * Updates a given sequence_details record with the data from the provided SequenceDetail object
     * @param sDetail  the SequenceDetail object to be updated
     */
    public void updateSequenceDetail(SequenceDetail sDetail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to update a sequence detail.");
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(sDetail);
            tx.commit();
            logger.debug("Sequence detail updated.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to update sequence detail.");
            if (tx != null) {
                tx.rollback();
                logger.error("Rolling back sequence detail update transaction.");
            }
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }
    }

    /**
     * Deletes a sequence_details record matching the provided id
     * @param sDetailId    the id of the record to be deleted
     */
    public void deleteSequenceDetail(int sDetailId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.debug("Session opened to delete a sequence detail.");
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            SequenceDetail sDetail = (SequenceDetail)session.load(SequenceDetail.class, new Integer(sDetailId));
            session.delete(sDetail);
            tx.commit();
            logger.debug("Sequence detail deleted.");
        } catch (HibernateException hex) {
            logger.error("Exception while attempting to delete sequence detail.");
            if (tx != null) {
                tx.rollback();
                logger.error("Rolling back sequence detail delete transaction.");
            }
            hex.printStackTrace();
        } finally {
            session.close();
            logger.debug("Closing session.");
        }
    }
}
