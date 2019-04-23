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
import java.util.List;

//this one loads the checkbox to screen
@WebServlet("/RemovalServlet")
public class RemovalServlet extends HttpServlet {

    //String dashName2 = "remove page";
    //MilestoneBoard test_dash2 = new MilestoneBoard(dashName2);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        List<Project> theProjects = MilestoneBoard.getInstance("Arit's Board").getProjects();
        String dashName2 = MilestoneBoard.getInstance("Arit's Board").getName();

        String destination = "remove_project.jsp";
        req.setAttribute("dashName", dashName2);
        req.setAttribute("projects",theProjects);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
