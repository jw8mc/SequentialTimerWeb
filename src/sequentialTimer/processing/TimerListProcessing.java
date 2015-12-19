package sequentialTimer.processing;

import org.apache.log4j.Logger;
import sequentialTimer.entity.*;
import sequentialTimer.persistence.Database;
import sequentialTimer.persistence.SequenceDetailDAO;
import sequentialTimer.persistence.SequentialTimerDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles retrieving and processing a sequence of timers.
 *
 * @author  Jen Williams
 * @version 1.0     11/30/2015
 */
public class TimerListProcessing {

    final static Logger logger = Logger.getLogger(TimerListProcessing.class);

    private List<SequentialTimer> timers;

    public List<SequentialTimer> getTimers() { return timers; }
    public void setTimers(List<SequentialTimer> timers) { this.timers = timers; }

    /**
     * Primary access method for the class - takes a TimerSequence object, gets all related
     * timer objects, and puts them into an array.
     *
     * @param   sequence        the TimerSequence object
     * @return  List<SequentialTimer> list of all timers in the sequence
     */
    public List<SequentialTimer> populateTimerArray(TimerSequence sequence) {

        //initializing the timer array
        timers = new ArrayList<SequentialTimer>();

        int sequenceId = sequence.getId();
        List<SequentialTimer> sequentialTimers = new ArrayList<SequentialTimer>();

        sequentialTimers = retrieveSequenceTimers(sequenceId);

        for (SequentialTimer timer : sequentialTimers) {
            timers.add(timer);
        }

        logger.info("Timers: " + timers);
        return timers;
    }

    /**
     * Gets all timers in a sequence and stores them in order.
     * @param sequenceId
     * @return
     */
    private List<SequentialTimer> retrieveSequenceTimers(int sequenceId) {

        List<SequenceDetail> details;
        List<SequentialTimer> sequentialTimers = new ArrayList<SequentialTimer>();

        details = retrieveSequenceDetails(sequenceId);

        Integer currentTimerId = null;

        while (sequentialTimers.size() < details.size()) {
            if (sequentialTimers.size() == 0) {
                //find the first timer in the sequence
                for (SequenceDetail detail : details) {
                    if (detail.getPrecedingTimerId() == 0) {
                        SequentialTimer timer = retrieveSequentialTimerById(detail.getSequentialTimerId());
                        sequentialTimers.add(timer);
                        currentTimerId = timer.getId();
                    }
                }
            } else {
                //find subsequent timers in the sequence
                for (SequenceDetail detail : details) {
                    if (detail.getPrecedingTimerId() == currentTimerId) {
                        SequentialTimer timer = retrieveSequentialTimerById(detail.getSequentialTimerId());
                        sequentialTimers.add(timer);
                        currentTimerId = timer.getId();
                    }
                }
            }
        }

        logger.info("Timers in the sequence: " + sequentialTimers);
        return sequentialTimers;
    }

    /**
     * Gets all sequence details for a sequence.
     * @param sequenceId
     * @return
     */
    private List<SequenceDetail> retrieveSequenceDetails(int sequenceId) {

        List<SequenceDetail> details = new ArrayList<SequenceDetail>();
        SequenceDetailDAO sdDao = new SequenceDetailDAO();

        try {
            Database.getInstance().connect();
            details = sdDao.getAllSequenceDetailsForTimerSequence(sequenceId);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        logger.info("Sequence details: " + details);
        return details;
    }

    /**
     * Gets a sequential timer record by id, using the SequentialTimerDAO.
     * @param timerId
     * @return
     */
    private SequentialTimer retrieveSequentialTimerById(int timerId) {
        SequentialTimerDAO stDao = new SequentialTimerDAO();
        SequentialTimer timer = null;

        try {
            Database.getInstance().connect();
            logger.debug("Database connection opened.");
            timer = stDao.getSequentialTimerById(timerId);
        } catch (SQLException sqle) {
            logger.error("SQL exception while attempting to retrieve a sequential timer by ID.");
            sqle.printStackTrace();
        } catch (Exception exc) {
            logger.error("Exception while attempting to retrieve a sequential timer by ID.");
            exc.printStackTrace();
        }

        logger.info("Timer: " + timer);
        return timer;
    }
}
