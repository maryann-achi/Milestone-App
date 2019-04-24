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

@WebServlet("/EditMilestoneServlet")
public class EditMilestoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String mile = req.getParameter("edit");
        String mileComp = req.getParameter("milestoneComplete");
        String projectName = req.getParameter("projTitle");

        Project presentProject = MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName);

        Milestone editThis = MilestoneBoard.getInstance("Arit's Board").getProjectByName(projectName).getMilestoneByName(mile);

        editThis.setCompletionDate(mileComp);

        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestones",presentProject.getMilestones());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
