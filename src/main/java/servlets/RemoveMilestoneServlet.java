package servlets;

import database.H2Milestone;
import database.H2Project;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/RemoveMilestoneServlet")
public class RemoveMilestoneServlet extends HttpServlet {
    H2Project h2Project = new H2Project();
    H2Milestone h2Milestone = new H2Milestone();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String projectName = req.getParameter("projTitle");
        String[] removeThese = req.getParameterValues("removalM");
        int userid = Integer.parseInt(req.getParameter("userid"));

        Project temp = null;
        List<Project> theProjects = h2Project.findProjects(userid);
        for(Project proj: theProjects){
            if(proj.getTitle().equals(projectName)){
                temp = proj;
            }
        }
        int id = temp.getId();
        List<Milestone> check = h2Milestone.findMilestones(id);
        for(String test: removeThese){
            int testInt = Integer.parseInt(test);
            h2Milestone.removeMilestone(testInt);
        }

        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestones", check);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String projectName = req.getParameter("projectTitle");
        Project presentProject = MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName);

        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestones",presentProject.getMilestones());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
