package sequentialTimer.processing;

import sequentialTimer.entity.SequentialTimer;
import sequentialTimer.entity.User;
import sequentialTimer.persistence.SequentialTimerDAO;
import sequentialTimer.persistence.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet takes form data from AddNewTimer.jsp and inserts it as a new sequentialTimer record.
 */
//@javax.servlet.annotation.WebServlet(name = "addNewTimer", urlPatterns = {"/addnewtimer"})
public class AddNewTimerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int snooze = Integer.parseInt(request.getParameter("snooze"));

        UserDAO uDao = new UserDAO();
        User user = uDao.getUserByUsername(username);

        int userId = user.getId();

        SequentialTimer st = new SequentialTimer(0, name, duration, snooze, userId);

        SequentialTimerDAO stDao = new SequentialTimerDAO();
        stDao.createSequentialTimer(st);

        //response.sendRedirect("closeWindow.html");
    }
}
