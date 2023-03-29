import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.*;


@WebServlet(name="SqlConnNoWebXml",urlPatterns="/test3")

public class SqlConnNoWebXml extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {	
		try{
			
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from customer");
			ResultSetMetaData rsmd=rs.getMetaData();
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Customer Info Page</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Customer Information</h1>");
			out.println("<table border=\"1\"><tr><th>"+rsmd.getColumnName(1)+"</th><th>"+rsmd.getColumnName(2)+"</th><th>"+rsmd.getColumnName(1)+"</th></tr>");
			while(rs.next())
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
				out.println("</body>");
				out.println("</html>");
		}catch(Exception e){}
    }
}