package servlets;

import model.Milestone;
import model.MilestoneBoard;
import model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/AddMilestoneServlet")
public class AddMilestoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String mileTitle = req.getParameter("milestoneTitle");
        String mileDesc = req.getParameter("milestoneDesc");
        String mileDue = req.getParameter("milestoneDue");
        String projectName = req.getParameter("projTitle");

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
        Project presentProject = MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName);
        presentProject.addMilestone(newMilestone);
//        List<Milestone> milestones = presentProject.getMilestones();


        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestoneTitle", mileTitle);
        req.setAttribute("milestones",presentProject.getMilestones());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
