package sequentialTimer;

import org.junit.*;

import sequentialTimer.entity.AnchorTimer;
import sequentialTimer.entity.User;
import sequentialTimer.persistence.AnchorTimerDAO;
import sequentialTimer.persistence.Database;
import sequentialTimer.persistence.UserDAO;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jen on 11/29/2015.
 */
public class AnchorTimerTest {

    private static int userId;
    private static int addedTimerId;

    @Ignore
    @BeforeClass
    public static void testSetup() {

        int newId = 0;
        String username = "testuser";
        String userpass = "testpass";

        User testUser = new User(newId, username, userpass);

        UserDAO userDao = new UserDAO();
        try {
            Database.getInstance().connect();
            userId = userDao.createUser(testUser);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testNewAnchorTimer() {
        int timerId = 0;
        String timerName = "Test Anchor Timer";
        Time testTime = Time.valueOf("12:00:00");
        int testSnooze = 5;
        int testOwner = userId;

        Integer newTimerId = null;

        AnchorTimer testAnchor = new AnchorTimer(timerId, timerName, testTime, testSnooze, testOwner);

        AnchorTimerDAO atDao = new AnchorTimerDAO();

        try {
            Database.getInstance().connect();
            newTimerId = atDao.createAnchorTimer(testAnchor);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        addedTimerId = newTimerId;
        Assert.assertNotNull(newTimerId);
    }

    @Ignore
    @Test
    public void testGetAnchorTimerById() {
        AnchorTimerDAO atDao = new AnchorTimerDAO();
        AnchorTimer retrievedTimer = null;
        try {
            Database.getInstance().connect();
            retrievedTimer = atDao.getAnchorTimerById(addedTimerId);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        Assert.assertNotNull(retrievedTimer);
    }

    @Ignore
    @Test
    public void testGetAnchorTimersForUser() {
        AnchorTimerDAO atDao = new AnchorTimerDAO();
        List<AnchorTimer> retrievedTimers = null;
        try {
            Database.getInstance().connect();
            retrievedTimers = atDao.getAllAnchorTimersForUser(userId);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        Assert.assertNotNull(retrievedTimers);
    }

    @Ignore
    @Test
    public void testGetAllAnchorTimers() {
        AnchorTimerDAO atDao = new AnchorTimerDAO();
        List<AnchorTimer> retrievedTimers = null;
        try {
            Database.getInstance().connect();
            retrievedTimers = atDao.getAllAnchorTimers();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        Assert.assertNotNull(retrievedTimers);
    }

    @Ignore
    @AfterClass
    public static void testCleanup() {
        UserDAO userDao = new UserDAO();
        userDao.deleteUser(userId);

        AnchorTimerDAO atDao = new AnchorTimerDAO();
        atDao.deleteAnchorTimer(addedTimerId);
    }
}
