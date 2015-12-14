package sequentialTimer.entity;

import java.util.Date;

/**
 * Represents a sequence of timers.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class TimerSequence {

    private int id;
    private Date startTime;
    private String repeatSettings;
    private int numberOfTimers;
    private int ownerId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public int getNumberOfTimers() { return numberOfTimers; }
    public String getRepeatSettings() { return repeatSettings; }
    public void setRepeatSettings(String repeatSettings) { this.repeatSettings = repeatSettings; }
    public void setNumberOfTimers(int numberOfTimers) { this.numberOfTimers = numberOfTimers; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    /**
     * Empty constructor that takes no parameters.
     */
    public TimerSequence() {}

    /**
     * Constructor that takes three parameters to populate the data object.
     * numberOfTimers will be populated later by a query
     * @param id
     * @param startTime
     * @param repeatSettings
     * @param ownerId
     */
    public TimerSequence(int id, Date startTime, String repeatSettings, int ownerId) {
        this();
        this.id = id;
        this.startTime = startTime;
        this.repeatSettings = repeatSettings;
        this.ownerId = ownerId;
    }

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Sequence ID: " + id
                + System.lineSeparator() + "Anchor Timer ID: " + startTime
                + System.lineSeparator() + "Owner: " + ownerId
                + System.lineSeparator() + "Number of sequential timers:" + numberOfTimers;
    }
}
