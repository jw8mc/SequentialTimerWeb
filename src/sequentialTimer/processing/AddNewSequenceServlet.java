package sequentialTimer.processing;

import org.apache.log4j.Logger;
import sequentialTimer.entity.TimerSequence;
import sequentialTimer.entity.User;
import sequentialTimer.persistence.TimerSequenceDAO;
import sequentialTimer.persistence.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * This servlet takes form data from AddNewSequence.jsp and inserts it as a new TimerSequence object.
 */
//@WebServlet(name = "AddNewSequenceServlet")
public class AddNewSequenceServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(AddNewSequenceServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        UserDAO uDao = new UserDAO();
        User user = uDao.getUserByUsername(username);

        int userId = user.getId();

        String[] checkValues = request.getParameterValues("repeat");
        String repeat = "";
        for (int i = 0; i < checkValues.length; i++) {
            repeat += (" " + checkValues[i]);
        }
        logger.debug("Repeat settings: " + repeat);

        String start = request.getParameter("start");

        TimerSequence ts = new TimerSequence(0, start, repeat, userId);
        logger.debug("Timer sequence: " + ts.toString());

        TimerSequenceDAO tsDao = new TimerSequenceDAO();
        tsDao.createTimerSequence(ts);
    }
}
