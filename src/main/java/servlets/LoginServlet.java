package servlets;

import database.H2User;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private H2User h2User = new H2User();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
      request.getRequestDispatcher("index.jsp").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");


        User user = new User(name, name, "email@email.com");
        this.h2User.addPerson(user);

        if(password.equals("admin123")){
            out.println("Welcome to your Milestone dashboard, " + name);
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
        }
        else{
            out.println("Your username or password is incorrect, please try again!");
            //request.getRequestDispatcher("index.jsp").include(request, response);
        }

        out.close();
    }
}
