package sequentialTimer.entity;

import java.sql.Time;

/**
 * Represents an Anchor Timer record.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class AnchorTimer extends TimerBase {

    private Time time;

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }


    /**
     * Empty constructor that takes no parameters.
     */
    public AnchorTimer() {
        setAcknowledgedState(false);
    }

    /**
     * Constructor that takes six parameters to populate the data object.
     * @param id    a unique int representing the record - if passed as 0 creates new record
     * @param name      a string naming the timer
     * @param time     an SQL time parameter for when the alarm should begin
     * @param snoozeLength      an int representing how long to snooze the alarm - if 0 snooze is disabled
     * @param ownerId   the user who created the timer
     */
    public AnchorTimer(int id, String name, Time time, int snoozeLength, int ownerId) {
        this();
        setId(id);
        setName(name);
        this.time = time;
        setSnoozeLength(snoozeLength);
        setOwnerId(ownerId);
    }

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Alarm: " + getName() + " (" + getId()+ ") at " + time + "."
                + System.lineSeparator() + "Snoozes for: " + getSnoozeLength() + " minutes";
    }
}