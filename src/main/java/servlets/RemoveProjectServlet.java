package servlets;

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

@WebServlet("/RemoveProjectServlet")
public class RemoveProjectServlet extends HttpServlet {
    //    this test dashboard will be converted into a singleton that is attached to each individual user
//    private String dashName = "mimidoo's projects";
//    MilestoneBoard test_dash1 = new MilestoneBoard(dashName);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String[] removeThese = req.getParameterValues("removals");
        List<Project> projects = new ArrayList<>();
        for (String str: removeThese) {
            projects.add(MilestoneBoard.getInstance("Arit's Board").getProjectByName(str));
        }

        MilestoneBoard.getInstance("Arit's Board").removeProject(projects);

        List<Project> updatedProjects = MilestoneBoard.getInstance("Arit's Board").getProjects();

        String dashName1 = MilestoneBoard.getInstance("Arit's Board").getName();

        String destination = "dashboard.jsp";
        req.setAttribute("dashName", dashName1);
        req.setAttribute("projects",updatedProjects);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
