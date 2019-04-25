package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MilestoneMenuServlet")
public class MilestoneMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] urls = req.getParameterValues("name");//since I have added a name attribute to the url in the anchor
        //I can now pass the value into the logic
        int userid = Integer.parseInt(req.getParameter("userid"));

        String destination = "project.jsp";
        req.setAttribute("url", urls[0]);//specifically gets the first element in the url array which is the project name
        req.setAttribute("userid", userid);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req, resp);
    }
}
