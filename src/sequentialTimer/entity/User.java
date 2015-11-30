package sequentialTimer.entity;

/**
 * Represents a user.
 *
 * @author Jen Williams
 * @version 1.0
 */
public class User {

    private int id;
    private String userName;
    private String userPass;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserPass() { return userPass; }
    public void setUserPass(String userPass) { this.userPass = userPass; }

    /**
     * Empty constructor that takes no parameters.
     */
    public User() {}

    /**
     * Constructor that takes three parameters to populate the data object.
     * @param id        an int representing a unique user
     * @param userName  a string representing the user's profile name
     * @param userPass  a string representing the user's password
     */
    public User(int id, String userName, String userPass) {
        this();
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
    }
}
