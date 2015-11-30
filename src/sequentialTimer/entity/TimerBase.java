package sequentialTimer.entity;

/**
 * Created by Student on 11/29/2015.
 */
public abstract class TimerBase {

    private int id;
    private String name;
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

    public abstract String toString();
}
