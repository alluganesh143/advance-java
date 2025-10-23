import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("username");
        
        out.println("<html><body style='font-family: Arial; text-align: center;'>");
        out.println("<h2>✅ Hello, " + name + "!</h2>");
        out.println("<p>Welcome to your first Servlet application.</p>");
        out.println("</body></html>");
    }
}
