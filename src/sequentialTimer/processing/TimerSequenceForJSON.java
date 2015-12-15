package sequentialTimer.processing;

import java.util.Date;
import java.util.List;

/**
 * This class represents a timer sequence in a format that will be converted to a JSON object.
 */
public class TimerSequenceForJSON {

    private Date start;
    private List<SequentialTimerForJSON> timers;

    public Date getStart() { return start; }
    public void setStart(Date start) { this.start = start; }
    public List<SequentialTimerForJSON> getTimers() { return timers; }
    public void setTimers(List<SequentialTimerForJSON> timers) { this.timers = timers; }

    public TimerSequenceForJSON(Date start, List<SequentialTimerForJSON> timers) {
        this.start = start;
        this.timers = timers;
    }
}
