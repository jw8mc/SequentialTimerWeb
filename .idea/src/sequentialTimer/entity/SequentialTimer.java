package src.sequentialTimer.entity;

/**
 * Represents a Sequential Timer record.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class SequentialTimer extends BaseTimer {

    private int length;

    /**
     * Empty constructor that takes no parameters.
     */
    public SequentialTimer() {}

    /**
     * Constructor that takes three paramters to populate the data object.
     * @param id    a unique int representing the record
     * @param timerName     a string describing the record
     * @param length    an int representing how long to delay this alarm
     */
    public SequentialTimer(int id, String timerName, int length, String description) {
        this();
        this.id = id;
        this.timerName = timerName;
        this.length = timerName;
        this.description = description;
    }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public String toString() {
        return System.lineSeparator() + "Timer: " + timerName + " (" + id + ") for " + length + " minutes."
                + System.lineSeparator() + "Description: " + description;
    }
}