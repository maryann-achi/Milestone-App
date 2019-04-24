package servlets;

import database.H2Project;
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
    private H2Project h2Project = new H2Project();

//    this test dashboard will be converted into a singleton that is attached to each individual user
    //private String dashName = "mimidoo's projects";
    //MilestoneBoard test_dash1 = new MilestoneBoard(dashName);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        //receives the project title from the form that has been sent

        String newProjectTitle = req.getParameter("projectTitle");
        System.out.println(req.getParameter("userid"));
        int userid = Integer.parseInt(req.getParameter("userid"));



        //creates a new project using the specified title
        Project newProj = new Project(userid, newProjectTitle);
        h2Project.addProject(newProj);
        //test_dash1.addProject(newProj);
        //MilestoneBoard.getInstance("Arit's Board").addProject(newProj);

        //List<Project> updatedProjects = test_dash1.getProjects();
        //List<Project> updatedProjects = MilestoneBoard.getInstance("Arit's Board").getProjects();

        List<Project> updatedProjects = h2Project.findProjects(userid);

        //String dashName1 = test_dash1.getName();
        //String dashName1 = MilestoneBoard.getInstance("Arit's Board").getName();

        String destination = "dashboard.jsp";
        req.setAttribute("dashName", "maryann");
        req.setAttribute("projects",updatedProjects);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        int userid = Integer.parseInt(req.getParameter("userid"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add_project.jsp");
        requestDispatcher.forward(req, resp);
    }
}
