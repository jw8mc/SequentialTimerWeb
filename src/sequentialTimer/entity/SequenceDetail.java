package sequentialTimer.entity;

/**
 * Represents one timer in a sequence.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class SequenceDetail {

    private int id;
    private int timerSequenceId;
    private int sequentialTimerId;
    private int precedingTimerId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getTimerSequenceId() { return timerSequenceId; }
    public void setTimerSequenceId(int timerSequenceId) { this.timerSequenceId = timerSequenceId; }
    public int getSequentialTimerId() { return sequentialTimerId; }
    public void setSequentialTimerId(int sequentialTimerId) { this.sequentialTimerId = sequentialTimerId; }
    public int getPrecedingTimerId() { return precedingTimerId; }
    public void setPrecedingTimerId(int precedingTimerId) { this.precedingTimerId = precedingTimerId; }

    /**
     * Empty constructor that takes no parameters.
     */
    public SequenceDetail() {}

    /**
     * Constructor that takes three parameters to populate the data object.
     * @param timerSequenceId       int that represents the specific record
     * @param sequentialTimerId     int that represents the timer to call
     * @param precedingTimerId      int that represents which timer this record should follow
     */
    public SequenceDetail(int timerSequenceId, int sequentialTimerId, int precedingTimerId) {
        this.timerSequenceId = timerSequenceId;
        this.sequentialTimerId = sequentialTimerId;
        this.precedingTimerId = precedingTimerId;
    }

    /**
     * Returns a string with object information.
     * @return String
     */
    @Override
    public String toString() {
        return System.lineSeparator() + "Record ID: " + id
                +System.lineSeparator() + "Belongs to sequence: " + timerSequenceId
                + System.lineSeparator() + "Sequential Timer ID: " + sequentialTimerId
                + System.lineSeparator() + "Follows: " + precedingTimerId;
    }
}
