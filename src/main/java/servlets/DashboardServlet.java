package servlets;

import database.H2Milestone;
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

@SuppressWarnings("ALL")
@WebServlet("/dashboards")
public class DashboardServlet extends HttpServlet {
    private H2Project h2Project = new H2Project();
    private H2Milestone h2Milestone = new H2Milestone();


    static final Logger LOG = LoggerFactory.getLogger(DashboardServlet.class);
    //edit that will be added to the login class, every time a new user is created, a unique dashboard is added to them
    //then the get instance is used to get the dashboard from them
    private String dashName = "Arit's Board";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        set the content type and status for the page
        resp.setContentType("text/html");
        resp.setStatus(200);

        int userid = Integer.parseInt(req.getParameter("userid"));
        List<Project> updatedProjects = h2Project.findProjects(userid);

        String destination = "dashboard.jsp";
        req.setAttribute("dashName", dashName);
        req.setAttribute("projects",updatedProjects);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
