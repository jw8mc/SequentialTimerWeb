import junit.framework.Assert;
import org.hibernate.HibernateException;
import org.junit.Ignore;
import org.junit.Test;
import sequentialTimer.entity.User;
import sequentialTimer.persistence.UserDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Student on 12/14/2015.
 */
public class TestUserDAO {

    private Integer addedUserId;
@Ignore
    @Test
    public void testAddUser() {
        User testUser = new User(0, "testUserName", "testPassword");
        UserDAO uDao = new UserDAO();
        addedUserId = uDao.createUser(testUser);
        Assert.assertNotNull(addedUserId);
    }
    @Ignore
    @Test
    public void testGetAllUsers() {
        UserDAO uDao = new UserDAO();
        List<User> listReturn = uDao.getAllUsers();
        Assert.assertTrue(listReturn.size() > 0);
    }
    @Ignore
    @Test
    public void testGetUserById() {
        UserDAO uDao = new UserDAO();
        User returnedUser = uDao.getUserById(addedUserId);
        Assert.assertNotNull(returnedUser);
    }
    @Ignore
    @Test
    public void testUpdateUser() {
        UserDAO uDao = new UserDAO();
        User userToUpdate = new User(addedUserId, "newUserName", "newPassword");
        uDao.updateUser(userToUpdate);
        User retrievedUser = uDao.getUserById(addedUserId);
        Assert.assertEquals("newUserName", retrievedUser.getUserName());
    }
    @Ignore
    @Test(expected = HibernateException.class)
    public void testUpdateUserToFail() {
        UserDAO uDao = new UserDAO();
        User userToUpdate = new User(addedUserId, "", "");
        uDao.updateUser(userToUpdate);
        Assert.fail("Expected a Hibernate exception for trying to assign null to a non-nullable field.");
    }
    @Ignore
    @Test
    public void testDeleteUser() {
        UserDAO uDao = new UserDAO();
        uDao.deleteUser(addedUserId);
        User checkDelete = uDao.getUserById(addedUserId);
        Assert.assertNull(checkDelete);
    }
}
