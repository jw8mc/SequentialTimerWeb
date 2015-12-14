package sequentialTimer.processing;

import sequentialTimer.entity.TimerSequence;
import sequentialTimer.persistence.TimerSequenceDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public AllTimerProcessing(int userId) {
        this.userId = userId;
    }

    public void processSequences() {
        retrieveSequences();
        sortSequences();
        for (TimerSequence ts : allSequences) {
            //get all sequence timers in order
            //add them to an array
            //put it all into a json object
            //add json object to json array
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
