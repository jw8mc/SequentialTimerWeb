package sequentialTimer.entity;

/**
 * Represents a Sequential Timer record.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class SequentialTimer {

    private int id;
    private String name;
    private int length;
    private int snoozeLength;
    private int ownerId;
    //the acknowledgedState is used only for timers currently in progress, it is not part of database actions
    private boolean acknowledgedState;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getSnoozeLength() { return snoozeLength; }
    public void setSnoozeLength(int snoozeLength) { this.snoozeLength = snoozeLength; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public boolean getAcknowledgedState() { return acknowledgedState; }
    public void setAcknowledgedState(boolean state) { this.acknowledgedState = state; }
    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    /**
     * Empty constructor that takes no parameters.
     */
    public SequentialTimer() {
        setAcknowledgedState(false);
    }

    /**
     * Constructor that takes five paramters to populate the data object.
     * @param id    a unique int representing the record - if passed as 0 creates new record
     * @param name     a string naming the timer
     * @param length    an int representing how long to delay this alarm
     * @param snoozeLength      an int representing how long to snooze the alarm - if 0, snooze is disabled
     * @param ownerId   the user who created the timer
     */
    public SequentialTimer(int id, String name, int length, int snoozeLength, int ownerId) {
        this();
        setId(id);
        setName(name);
        this.length = length;
        setSnoozeLength(snoozeLength);
        setOwnerId(ownerId);
    }

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Timer: " + getName() + " (" + getId() + ") for " + length + " minutes."
                + System.lineSeparator() + "Snoozes for: " + getSnoozeLength() + " minutes";
    }
}