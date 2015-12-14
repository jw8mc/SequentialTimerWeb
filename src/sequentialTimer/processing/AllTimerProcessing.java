package sequentialTimer.processing;

//import com.google.api.client.util.DateTime;
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
        //sortSequences();
    }

    private void retrieveSequences() {
        TimerSequenceDAO tsDao = new TimerSequenceDAO();
        allSequences = tsDao.getAllTimerSequencesForUser(userId);
    }
/*
    private void sortSequences() {
        Collections.sort(allSequences, new Comparator<TimerSequence>() {
            public int compare(TimerSequence ts1, TimerSequence ts2) {
                DateTime a = ts1.
            }
        };
    }*/

}
