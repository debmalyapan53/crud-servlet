import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		try {
			Connection conn = Connector.getConnection();
			List<Employee> list = Connector.viewQuery(conn);
			PrintWriter out = res.getWriter();
			out.println("<html>"
					+ "			<body>"
					+ "			<table border=1>"
					+ "				<th>EId</th>"
					+ "				<th>EName</th>"
					+ "				<th>Pwd</th>"
					+ "				<th>Email</th>"
					+ "				<th>Country</th>");
			for(Employee e: list) {
				out.println("<tr>"
						+"		<td>"+e.getId()+"</td>"
						+"		<td>"+e.getName()+"</td>"	
						+"		<td>"+e.getPwd()+"</td>"	
						+"		<td>"+e.getEmail()+"</td>"
						+"		<td>"+e.getCountry()+"</td>"
						+"		<td><a href='Edit?id="+e.getId()+"'>Edit</a></td>"
						+"		<td><a href='Delete?id="+e.getId()+"'>Delete</a></td>"
						+"</tr>"
						);
			}
			out.println("</table></body></html>");
			conn.close();
		}
		catch(Exception ex) {
			res.getWriter().println("Select query failed\n"+ex);
		}
		finally {
			res.getWriter().println("<a href=\"index.html\">Go Back</a>");
		}
	}
}
