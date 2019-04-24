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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RemoveMilestoneServlet")
public class RemoveMilestoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String projectName = req.getParameter("projTitle");
        String[] removeThese = req.getParameterValues("removalM");
        List<Milestone> milestones = new ArrayList<>();
        for (String str: removeThese) {
            milestones.add(MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName).getMilestoneByName(str));
        }

//        remove all the matching milestones from the project
        MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName).removeMilestones(milestones);

        Project presentProject = MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName);

        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestones",presentProject.getMilestones());

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
