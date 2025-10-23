package loginServlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// ✅ This automatically registers servlet in Tomcat
@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            out.println("<h2 style='color:green;'>Login Successful!</h2>");
        } else {
            out.println("<h2 style='color:red;'>Invalid Username or Password!</h2>");
            out.println("<a href='index.html'>Try again</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3 style='color:blue;'>Please submit the login form instead.</h3>");
        out.println("<a href='index.html'>Go to Login Page</a>");
    }
}
