package sequentialTimer.processing;

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

    private List<TimerBase> timers;

    public List<TimerBase> getTimers() { return timers; }
    public void setTimers(List<TimerBase> timers) { this.timers = timers; }

    /**
     * Primary access method for the class - takes a TimerSequence object, gets all related
     * timer objects, and puts them into an array.
     *
     * @param   sequence        the TimerSequence object
     * @return  List<TimerBase> list of all timers in the sequence
     */
    public List<TimerBase> populateTimerArray(TimerSequence sequence) {

        //initializing the timer array
        timers = new ArrayList<TimerBase>();

        int sequenceId = sequence.getId();
        //int anchorTimerId = sequence.getAnchorTimerId();
        List<SequentialTimer> sequentialTimers = new ArrayList<SequentialTimer>();

       //AnchorTimer sequenceAnchorTimer = retrieveAnchorTimer(anchorTimerId);
        sequentialTimers = retrieveSequenceTimers(sequenceId);

        for (SequentialTimer timer : sequentialTimers) {
            timers.add(timer);
        }

        return timers;
    }

    /**
     *
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

        return sequentialTimers;
    }

    /**
     *
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

        return details;
    }

    /**
     *
     * @param timerId
     * @return
     */
    private SequentialTimer retrieveSequentialTimerById(int timerId) {
        SequentialTimerDAO stDao = new SequentialTimerDAO();
        SequentialTimer timer = null;

        try {
            Database.getInstance().connect();
            timer = stDao.getSequentialTimerById(timerId);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return timer;
    }
}
