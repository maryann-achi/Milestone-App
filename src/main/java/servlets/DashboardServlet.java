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

@WebServlet("/dashboards")
public class DashboardServlet extends HttpServlet {
    static final Logger LOG = LoggerFactory.getLogger(DashboardServlet.class);

    private String dashName = "test_name";

//    public DashboardServlet (String dashBoardName){
//        this.dashName = dashBoardName;
//    }
MilestoneBoard test_dash = new MilestoneBoard(dashName);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        set the content type and status for the page
        resp.setContentType("text/html");
        resp.setStatus(200);
//        access the projects from the singleton MilestoneBoard object and store them in a variable
        //List<Project> projects = MilestoneBoard.getInstance(this.dashName).getProjects();
        List<Project> projects = test_dash.getProjects();
        String dashName = test_dash.getName();
//        following code is written with help from codejava.net
//        add the destination for the data to be sent
        String test99 = "testhe";
        String destination = "dashboard.jsp";
        req.setAttribute("dashName", dashName);
        req.setAttribute("projects",projects);
        req.setAttribute("test99", test99);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);

    }
}
