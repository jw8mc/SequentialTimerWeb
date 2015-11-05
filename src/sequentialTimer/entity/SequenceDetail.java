package sequentialTimer.entity;

/**
 * Represents one timer in a sequence.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class SequenceDetail {

    private int timerSequenceId;
    private int sequentialTimerId;
    private int preceedingTimerId;

    public int getTimerSequenceId() { return timerSequenceId; }
    public void setTimerSequenceId(int timerSequenceId) { this.timerSequenceId = timerSequenceId; }
    public int getSequentialTimerId() { return sequentialTimerId; }
    public void setSequentialTimerId(int sequentialTimerId) { this.sequentialTimerId = sequentialTimerId; }
    public int getPreceedingTimerId() { return preceedingTimerId; }
    public void setPreceedingTimerId(int preceedingTimerId) { this.preceedingTimerId = preceedingTimerId; }

    /**
     * Empty constructor that takes no parameters.
     */
    public SequenceDetail() {}

    /**
     * Constructor that takes three parameters to populate the data object.
     * @param timerSequenceId       int that represents the specific record
     * @param sequentialTimerId     int that represents the timer to call
     * @param preceedingTimerId     int that represents which timer this record should follow
     */

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Record ID: " + timerSequenceId
                + System.lineSeparator() + "Sequential Timer ID: " + sequentialTimerId
                + System.lineSeparator() + "Follows: " + preceedingTimerId;
    }
}
