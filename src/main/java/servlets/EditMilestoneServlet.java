package servlets;

import database.H2Milestone;
import database.H2Project;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/EditMilestoneServlet")
public class EditMilestoneServlet extends HttpServlet {
    H2Project h2Project = new H2Project();
    H2Milestone h2Milestone = new H2Milestone();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);

        String mile = req.getParameter("edit");
        String mileComp = req.getParameter("milestoneComplete");
        String projectName = req.getParameter("projTitle");
        int userid = Integer.parseInt(req.getParameter("userid"));

        int changeThis = Integer.parseInt(mile);

        Date useThisDate = null;
        try {
            useThisDate = new SimpleDateFormat("yyyy-MM-dd").parse(mileComp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date newCplt = new java.sql.Date(useThisDate.getTime());
        h2Milestone.updateMilestoneCompDate(changeThis, newCplt);

        Project temporary = null;
        List<Project> theProjects = h2Project.findProjects(userid);
        for(Project project: theProjects){
            if(project.getTitle().equals(projectName)){
                temporary = project;
            }
        }

        int id = temporary.getId();
        List<Milestone> check = h2Milestone.findMilestones(id);


        String destination = "all_milestones.jsp";
        req.setAttribute("projectName",projectName);
        req.setAttribute("milestones",check);
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
