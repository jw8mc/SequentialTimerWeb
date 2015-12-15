package sequentialTimer.processing;

import sequentialTimer.entity.SequentialTimer;

import java.util.Date;
import java.util.List;

/**
 * This class represents a timer sequence in a format that will be converted to a JSON object.
 */
public class TimerSequenceForJSON {

    private Date start;
    private List<SequentialTimer> timers;

    public Date getStart() { return start; }
    public void setStart(Date start) { this.start = start; }
    public List<SequentialTimer> getTimers() { return timers; }
    public void setTimers(List<SequentialTimer> timers) { this.timers = timers; }

    public TimerSequenceForJSON(Date start, List<SequentialTimer> timers) {
        this.start = start;
        this.timers = timers;
    }
}
