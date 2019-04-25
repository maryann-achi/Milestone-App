package servlets;

import database.H2Project;
import model.MilestoneBoard;
import model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RemoveProjectServlet")
public class RemoveProjectServlet extends HttpServlet {

    private H2Project h2Project = new H2Project();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        int userid = Integer.parseInt(req.getParameter("userid"));

        List<Project> theProjects = h2Project.findProjects(userid);
        String[] removeThese = req.getParameterValues("removals");

        for (String str: removeThese){
            for(Project proj: theProjects){
                if(proj.getTitle().equals(str)){
                    int id = proj.getId();
                    System.out.println(id);
                    h2Project.removeProject(id);
                }
            }
        }

        String dashName1 = MilestoneBoard.getInstance("Arit's Board").getName();

        String destination = "dashboard.jsp";
        req.setAttribute("dashName", dashName1);
        req.setAttribute("projects",theProjects);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
