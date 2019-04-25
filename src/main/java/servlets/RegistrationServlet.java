package servlets;

import database.H2User;
import model.PasswordHash;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private H2User h2User = new H2User();
    PasswordHash newhash = new PasswordHash();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String password = request.getParameter("password");

        try {
            byte[] genSalt = newhash.getSalt();
            String hashedPassword = newhash.getHashPassword(password, genSalt);
            h2User.addUser(new User(name, email, hashedPassword, genSalt));
            request.getRequestDispatcher("login.jsp").include(request, response);
            out.println("You have successfully registered");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}

