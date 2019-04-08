package servlets;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import model.MilestoneBoard;
import model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DashboardServlet extends HttpServlet {
    static final Logger LOG = LoggerFactory.getLogger(DashboardServlet.class);

    private String dashName;

    public DashboardServlet (String dashBoardName){
        this.dashName = dashBoardName;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        set the content type and status for the page
        resp.setContentType("text/html");
        resp.setStatus(200);
//        access the projects from the singleton MilestoneBoard object and store them in a variable
        List<Project> projects = MilestoneBoard.getInstance(this.dashName).getProjects();

//        following code is written with help from codejava.net
//        add the destination for the data to be sent
        String destination = "dashboard.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);

        req.setAttribute("projects", projects);
        requestDispatcher.forward(req, resp);

    }
}
