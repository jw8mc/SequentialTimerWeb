package sequentialTimer.processing;

/**
 * This class represents a sequential timer in a format that will be converted to a JSON object.
 */
public class SequentialTimerForJSON {

    private String name;
    private int interval;
    private int snooze;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getInterval() { return interval; }
    public void setInterval(int interval) {this.interval = interval; }
    public int getSnooze() { return snooze; }
    public void setSnooze(int snooze) { this.snooze = snooze; }

    public SequentialTimerForJSON(String name, int interval, int snooze) {
        this.name = name;
        this.interval = interval;
        this.snooze = snooze;
    }
}
