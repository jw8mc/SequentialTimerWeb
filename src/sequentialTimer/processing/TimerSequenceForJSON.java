package sequentialTimer.processing;

import sequentialTimer.entity.SequentialTimer;

import java.util.Date;
import java.util.List;

/**
 * This class represents a timer sequence in a format that will be converted to a JSON object.
 */
public class TimerSequenceForJSON {

    private String start;
    private List<SequentialTimer> timers;

    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }
    public List<SequentialTimer> getTimers() { return timers; }
    public void setTimers(List<SequentialTimer> timers) { this.timers = timers; }

    /**
     * Constructor that takes two parameters, a time and an array of sequential timers.
     * @param start     the time the alarm will be set for
     * @param timers    an array of SequentialTimer objects, representing timers in the sequence
     */
    public TimerSequenceForJSON(String start, List<SequentialTimer> timers) {
        this.start = start;
        this.timers = timers;
    }
}
