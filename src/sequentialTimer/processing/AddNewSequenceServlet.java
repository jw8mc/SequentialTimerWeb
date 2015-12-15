package sequentialTimer.processing;

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
        //TODO: LOG CONCAT STRING HERE

        String start = request.getParameter("start");

        TimerSequence ts = new TimerSequence(0, start, repeat, userId);
        //TODO: LOG TOSTRING HERE

        TimerSequenceDAO tsDao = new TimerSequenceDAO();
        tsDao.createTimerSequence(ts);
    }
}
