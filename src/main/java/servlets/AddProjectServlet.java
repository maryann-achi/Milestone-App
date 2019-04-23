package servlets;

import model.MilestoneBoard;
import model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddProjectServlet")
public class AddProjectServlet extends HttpServlet {
    static final Logger LOG = LoggerFactory.getLogger(DashboardServlet.class);

    private String dashName = "mimidoo's projects";
    MilestoneBoard test_dash1 = new MilestoneBoard(dashName);

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);
        String newProjectTitle = req.getParameter("projectTitle");

        Project newProj = new Project(newProjectTitle);
        test_dash1.addProject(newProj);

        List<Project> updatedProjects = test_dash1.getProjects();

        String dashName1 = test_dash1.getName();

        String destination = "dashboard.jsp";
        req.setAttribute("dashName", dashName1);
        req.setAttribute("projects",updatedProjects);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
