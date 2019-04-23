package servlets;

import model.Milestone;
import model.MilestoneBoard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddMilestoneServlet")
public class AddMilestoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mileTitle = req.getParameter("milestoneTitle");
        String mileDesc = req.getParameter("milestoneDesc");
        String mileDue = req.getParameter("milestoneDue");

        //convert the string date received from the form to a date object
        Date dateDue= null;
        try {
            dateDue = new SimpleDateFormat("yyyy-MM-dd").parse(mileDue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //end of the date conversion
        Milestone newMilestone = new Milestone(mileTitle,mileDesc,dateDue);
        System.out.println(mileDue);
        //MilestoneBoard.getInstance().getProjectByName().addMilestone();
    }
}
