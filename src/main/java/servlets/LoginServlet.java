package servlets;

import database.H2Project;
import database.H2User;
import model.Project;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private H2User h2User = new H2User();
    private H2Project h2Project = new H2Project();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

      //request.getRequestDispatcher("index.jsp").include(request, response);


        String name = request.getParameter("name");
        String password = request.getParameter("password");


        User user = this.h2User.findUser(name, password);
        ArrayList<Project> projects = this.h2Project.findProjects(user.getId());
        request.setAttribute("projects", projects);
        //this.h2User.addUser(user);
        request.setAttribute("user", user);
        request.setAttribute("userid", user.getId());

        if(user != null){
            System.out.println("user not null");
            //out.println("Welcome to your Milestone dashboard, " + name);


            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//            HttpSession session = request.getSession();
//            session.setAttribute("name", name);
        }
        else{
            out.println("Your username or password is incorrect, please try again!");
            //request.getRequestDispatcher("index.jsp").include(request, response);
        }

        out.close();
    }
}
