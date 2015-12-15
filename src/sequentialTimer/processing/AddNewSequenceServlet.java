package sequentialTimer.processing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet takes form data from AddNewSequence.jsp and inserts it as a new TimerSequence object.
 */
//@WebServlet(name = "AddNewSequenceServlet")
public class AddNewSequenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //insert new sequence into database
        //get object for new record
        //put object in header
        //pass to new form to add timers
    }
}
