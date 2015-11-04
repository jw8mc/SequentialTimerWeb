package src.sequentialTimer.entity;

/**
 * Abstract class representing base Timer data.
 */
public abstract class BaseTimer {

    private String timerName;
    private String description;
    private int id;
    private int snoozeLength;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTimerName() { return timerName; }
    public void setTimerName(String timerName) { this.timerName = timerName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getSnoozeLength() { return snoozeLength; }
    public void setSnoozeLength(int snoozeLength) { this.snoozeLength = snoozeLength; }

    abstract String toString();
}