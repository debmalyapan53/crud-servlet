import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			Connection conn = Connector.getConnection();
			Connector.deleteQuery(conn,id);
			res.sendRedirect("View");
			conn.close();
		}
		catch(Exception ex) {
			res.getWriter().println("Delete query failed\n"+ex);
		}
	}
}
