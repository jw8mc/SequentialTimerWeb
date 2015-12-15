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
    private String startTime;
    private String repeatSettings;
    private int ownerId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getRepeatSettings() { return repeatSettings; }
    public void setRepeatSettings(String repeatSettings) { this.repeatSettings = repeatSettings; }
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
    public TimerSequence(int id, String startTime, String repeatSettings, int ownerId) {
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
                + System.lineSeparator() + "Owner: " + ownerId;
    }
}
