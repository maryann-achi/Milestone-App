package servlets;

import database.H2Milestone;
import database.H2Project;
import model.Milestone;
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
    private H2Project h2Project = new H2Project();
    private H2Milestone h2Milestone = new H2Milestone();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String mileTitle = req.getParameter("milestoneTitle");
        String mileDesc = req.getParameter("milestoneDesc");
        String mileDue = req.getParameter("milestoneDue");
        String projectName = req.getParameter("projTitle");
        int userid = Integer.parseInt(req.getParameter("userid"));

        //convert the string date received from the form to a date object
        Date dateDue= null;
        try {
            dateDue = new SimpleDateFormat("yyyy-MM-dd").parse(mileDue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //end of the date conversion
        List<Project> theProjects = h2Project.findProjects(userid);
        Milestone newMilestone = null;
        int id = 0;

        for(Project proj: theProjects){
            if(proj.getTitle().equals(projectName)){
                id = proj.getId();
                newMilestone = new Milestone(mileTitle, mileDesc, dateDue, id);
            }
        }
        h2Milestone.addMilestone(newMilestone);
        List<Milestone> theMilestones = h2Milestone.findMilestones(id);


        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestoneTitle", mileTitle);
        req.setAttribute("milestones", theMilestones);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);



        String projectName = req.getParameter("projectTitle");
        int userid = Integer.parseInt(req.getParameter("userid"));

        List<Project> theProjects = h2Project.findProjects(userid);

        int id = 0;

        for(Project proj: theProjects){
            if(proj.getTitle().equals(projectName)){
                id = proj.getId();

            }
        }

        List<Milestone> theMilestones = h2Milestone.findMilestones(id);

        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestones", theMilestones);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
