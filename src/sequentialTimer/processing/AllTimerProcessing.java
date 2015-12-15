package sequentialTimer.processing;

import sequentialTimer.entity.SequentialTimer;
import sequentialTimer.entity.TimerSequence;
import sequentialTimer.persistence.TimerSequenceDAO;

import java.util.*;

/**
 * Created by Student on 12/14/2015.
 */
public class AllTimerProcessing {
    //get user id
    //get all sequence id/objects for that user
    //call timerlistprocessing on each sequence object
    //create array of all timerlistprocessing returns
    //get array into JSON object
    //do I want to just covert it?
    //or only include the data I need on the javascipt side?
    //is there any discrepancy there? I guess the preceding timer part

    private int userId;
    private List<TimerSequence> allSequences;
    private List<TimerSequenceForJSON> allSequencesJSONable;

    public AllTimerProcessing(int userId) {
        this.userId = userId;
    }

    /**
     * Driving method that calls other class methods to process a user's timer sequences.
     */
    public void processSequences() {
        retrieveSequences();
        sortSequences();

        //after this method, the instance variable allSequencesJSONable will be populated
        convertToJSONable();
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
            Date start = ts.getStartTime();
            List<SequentialTimerForJSON> timersJSON = convertSequenceTimersToJSONable(timers);
            TimerSequenceForJSON tsJSON = new TimerSequenceForJSON(start, timersJSON);
            allSequencesJSONable.add(tsJSON);
        }
    }

    /**
     * Converts the sequence timers for a given sequence to an array of JSONable objects.
     * @param timers    the list of sequential timers for the sequence
     * @return  the list of JSONable timer objects
     */
    private List<SequentialTimerForJSON> convertSequenceTimersToJSONable(List<SequentialTimer> timers) {
        //list to hold JSONable timer objects
        List<SequentialTimerForJSON> timersJSON = new ArrayList<>();
        for (SequentialTimer st : timers) {
            SequentialTimerForJSON stJSON = new SequentialTimerForJSON(st.getName(), st.getLength(), st.getSnoozeLength());
            timersJSON.add(stJSON);
        }

        return timersJSON;
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
