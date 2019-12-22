import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		id = Integer.parseInt(req.getParameter("id"));
		try {
			Connection conn = Connector.getConnection();
			Employee e = Connector.retrieveQuery(conn,id);
			PrintWriter out = res.getWriter();
			out.println("<html>"
					+ "		<body>"
					+ "			<p>Update Employee Details:</p><br><br>"
					+ "	<form method=\"POST\" action=\"Edit\">"
					+ "		<label>EID</label>\r\n" + 
					"		<input type=\"text\" name =\"id\" value='"+e.getId()+"'/><br>\r\n" + 
					"		<label>Name</label>\r\n" + 
					"		<input type=\"text\" name =\"name\" value='"+e.getName()+"'/><br>\r\n" + 
					"		<label>Password</label>\r\n" + 
					"		<input type=\"password\" name =\"pwd\" value='"+e.getPwd()+"'/><br>\r\n" + 
					"		<label>E-Mail</label>\r\n" + 
					"		<input type=\"email\" name =\"email\" value='"+e.getEmail()+"'/><br>\r\n" + 
					"		<label>Country</label>\r\n" + 
					"		<input type=\"text\" name =\"country\" value='"+e.getCountry()+"'/><br>\r\n" + 
					"		<input type=\"submit\" name = \"update\" value=\"Update\"/><br>"+
					"	</form>"
					+ "<a href='View'>Go Back</a></body></html>"
					);
			conn.close();
		}
		catch(Exception ex) {
			res.getWriter().println("Delete query failed\n"+ex);
		}

	}

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		int new_id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		Employee e = new Employee(new_id,name, pwd, email, country);
		try {
			Connection conn = Connector.getConnection();
			Connector.updateQuery(conn, e,id);
			conn.close();
			res.sendRedirect("View");
			}
		catch(Exception ex) {
			res.getWriter().println("Update query failed\n"+ex);
		}

	}

}
