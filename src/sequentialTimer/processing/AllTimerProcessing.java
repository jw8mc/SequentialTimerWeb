package sequentialTimer.processing;

import org.apache.log4j.Logger;
import sequentialTimer.entity.SequentialTimer;
import sequentialTimer.entity.TimerSequence;
import sequentialTimer.persistence.TimerSequenceDAO;

import java.util.*;

/**
 * This class gets all timer sequences for the current user that have a repeat set for the current day. It processes
 * these sequence objects to retrieve and order their respective sequences of sequential timers, and then converts the
 * sequences into a JSON-friendly format for later use in the jsp.
 */
public class AllTimerProcessing {

    final static Logger logger = Logger.getLogger(AllTimerProcessing.class);

    private int userId;
    private List<TimerSequence> allSequences;
    private List<TimerSequenceForJSON> allSequencesJSONable;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public List<TimerSequence> getAllSequences() { return allSequences; }
    public void setAllSequences(List<TimerSequence> allSequences) { this.allSequences = allSequences; }
    public List<TimerSequenceForJSON> getAllSequencesJSONable() { return allSequencesJSONable; }
    public void setAllSequencesJSONable(List<TimerSequenceForJSON> allSequencesJSONable) { this.allSequencesJSONable = allSequencesJSONable; }

    /**
     * Constructor that takes a userId parameter.
     * @param userId    id of the current user
     */
    public AllTimerProcessing(int userId) {

        this.userId = userId;
        allSequencesJSONable = new ArrayList<TimerSequenceForJSON>();
    }

    /**
     * Driving method that calls other class methods to process a user's timer sequences.
     */
    public void processSequences() {
        retrieveSequences();
        sortSequences();

        //after this method, the instance variable allSequencesJSONable will be populated
        convertToJSONable();
        logger.info("JSONable sequences: " + allSequencesJSONable);
    }

    /**
     * Takes the list of timer sequence objects, accesses each one, and coverts it to a JSONable object.
     */
    private void convertToJSONable() {
        for (TimerSequence ts : allSequences) {
            //instantiate processor for sequence
            TimerListProcessing processor = new TimerListProcessing();

            //get sequence of timers for given sequence
            processor.populateTimerArray(ts);
            List<SequentialTimer> timers = processor.getTimers();

            //JSONable sequence object
            String start = ts.getStartTime();
            TimerSequenceForJSON tsJSON = new TimerSequenceForJSON(start, timers);
            allSequencesJSONable.add(tsJSON);
        }
    }

    /**
     * Instantiates a TimerSequenceDAO object and uses it to retrieve all of the user's timer sequences that repeat
     * today.
     */
    private void retrieveSequences() {
        TimerSequenceDAO tsDao = new TimerSequenceDAO();
        allSequences = tsDao.getAllTimerSequencesForUserForToday(userId);
    }

    /**
     * Uses a custom Comparator to sort the list of timer sequences by their start time.
     */
    private void sortSequences() {
        Collections.sort(allSequences, new Comparator<TimerSequence>() {
            public int compare(TimerSequence ts1, TimerSequence ts2) {
                return ts1.getStartTime().compareTo(ts2.getStartTime());
            }
        });
    }

}
