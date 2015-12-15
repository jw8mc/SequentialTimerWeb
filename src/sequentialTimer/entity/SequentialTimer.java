package sequentialTimer.entity;

/**
 * Represents a Sequential Timer record.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class SequentialTimer {

    private int id;
    private String timerName;
    private int duration;
    private int snoozeLength;
    private int ownerId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTimerName() { return timerName; }
    public void setTimerName(String name) { this.timerName = name; }
    public int getSnoozeLength() { return snoozeLength; }
    public void setSnoozeLength(int snoozeLength) { this.snoozeLength = snoozeLength; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    /**
     * Empty constructor that takes no parameters.
     */
    public SequentialTimer() {};

    /**
     * Constructor that takes five paramters to populate the data object.
     * @param id    a unique int representing the record - if passed as 0 creates new record
     * @param timerName     a string naming the timer
     * @param duration    an int representing how long to delay this alarm
     * @param snoozeLength      an int representing how long to snooze the alarm - if 0, snooze is disabled
     * @param ownerId   the user who created the timer
     */
    public SequentialTimer(int id, String timerName, int duration, int snoozeLength, int ownerId) {
        this();
        setId(id);
        setTimerName(timerName);
        setDuration(duration);
        setSnoozeLength(snoozeLength);
        setOwnerId(ownerId);
    }

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Timer: " + getTimerName() + " (" + getId() + ") for " + getDuration() + " minutes."
                + System.lineSeparator() + "Snoozes for: " + getSnoozeLength() + " minutes";
    }
}