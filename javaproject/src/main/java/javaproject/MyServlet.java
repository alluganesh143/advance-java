package javaproject;


	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.ServletException;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import jakarta.servlet.annotation.WebServlet;

	@WebServlet("/aaa")   // 👈 URL pattern
	public class MyServlet extends HttpServlet {
		 String url = "jdbc:mysql://localhost:3306/db";
	     String user = "root";
	     String password = "Ashok@mysql";
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	            throws ServletException, IOException {
	        System.out.println("Connection");
	        PrintWriter out=resp.getWriter();
	        out.println("<h1>Hii !</h1>");
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);
				System.out.println("connection is succesful");
				
				
				String query = "insert into dbtable(id,name,address,state)values(?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setInt(1,2);
				ps.setString(2, "ganesh");
				ps.setString(3, "kanapaka");
				ps.setString(4, "ap");
				ps.addBatch();
				
				
				ps.setInt(1,3);
				ps.setString(2, "vinay");
				ps.setString(3, "kanapaka");
				ps.setString(4, "ap");
				ps.addBatch();
				
				ps.setInt(1,4);
				ps.setString(2, "Guptha");
				ps.setString(3, "Bobbili");
				ps.setString(4, "AP");
				
				int[] p = ps.executeBatch();
				
				System.out.println("data is entered");
				
				
			} 
	       
	        catch (Exception e) {
				e.printStackTrace();
			} 
	    }
	}

