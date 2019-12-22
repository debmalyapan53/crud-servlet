import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		Employee e = new Employee(id,name, pwd, email, country);
		try {
			Connection conn = Connector.getConnection();
			Connector.saveQuery(conn, e);
			conn.close();
			res.sendRedirect("index.html");
		}
		catch(Exception ex) {
			res.getWriter().println("Insert query failed\n"+ex);
		}
	}
}
