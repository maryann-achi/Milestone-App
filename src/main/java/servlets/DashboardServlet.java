package servlets;

import model.Milestone;
import model.MilestoneBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@WebServlet("/dashboards")
public class DashboardServlet extends HttpServlet {
    static final Logger LOG = LoggerFactory.getLogger(DashboardServlet.class);
    //edit that will be added to the login class, every time a new user is created, a unique dashboard is added to them
    //then the get instance is used to get the dashboard from them
    private String dashName = "Arit's Board";

//    public DashboardServlet (String dashBoardName){
//        this.dashName = dashBoardName;
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        set the content type and status for the page
        resp.setContentType("text/html");
        resp.setStatus(200);
//        access the projects from the singleton MilestoneBoard object and store them in a variable
        //List<Project> projects = MilestoneBoard.getInstance(this.dashName).getProjects();
//        MilestoneBoard.getInstance(dashName).addProject(new Project("Ari Adetimehin"));
        List<Project> projects =MilestoneBoard.getInstance(dashName).getProjects();
//        String dashName = test_dash.getName();
//        following code is written with help from codejava.net
//        add the destination for the data to be sent

        String destination = "dashboard.jsp";
        req.setAttribute("dashName", dashName);
        req.setAttribute("projects",projects);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);

    }
}
