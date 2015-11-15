package sequentialTimer.entity;

import java.sql.Time;

/**
 * Represents an Anchor Timer record.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class AnchorTimer {

    private int id;
    private String name;
    private Time time;
    private int snoozeLength;
    private int ownerId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getSnoozeLength() { return snoozeLength; }
    public void setSnoozeLength(int snoozeLength) { this.snoozeLength = snoozeLength; }
    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    /**
     * Empty contructor that takes no parameters.
     */
    public AnchorTimer() {}

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
        this.id = id;
        this.name = name;
        this.time = time;
        this.snoozeLength = snoozeLength;
        this.ownerId = ownerId;
    }

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Alarm: " + name + " (" + id + ") at " + time + "."
                + System.lineSeparator() + "Snoozes for: " + snoozeLength + " minutes";
    }
}