import java.sql.*;
import java.util.*;
public class Connector {
	static Statement stmt = null;
	public static Connection getConnection() throws SQLException,ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");  
		}
	
	public static void saveQuery(Connection conn, Employee e) throws SQLException {
		stmt = conn.createStatement();
		String sql = "INSERT INTO employee VALUES("+e.getId()+",'"+e.getName()+"','"+e.getPwd()+"','"+e.getEmail()+"','"+e.getCountry()+"')";
		stmt.execute(sql);
		stmt.close();
	}
	
	public static List<Employee> viewQuery(Connection conn) throws SQLException{
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                ResultSet.CONCUR_UPDATABLE);
		String sql = "SELECT * FROM employee;";
		ResultSet rs = stmt.executeQuery(sql);
		List<Employee> list = new ArrayList<Employee> ();
		while(rs.next()) {
			list.add(new Employee(rs.getInt("id"),rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("country")));
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public static void deleteQuery(Connection conn,int id) throws SQLException{
		stmt = conn.createStatement();
		String sql = "DELETE FROM employee WHERE id="+id;
		stmt.execute(sql);
		stmt.close();
	}
	
	public static Employee retrieveQuery(Connection conn, int id) throws SQLException{
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                ResultSet.CONCUR_UPDATABLE);
		String sql = "SELECT * FROM employee WHERE id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		Employee e = null;
		while(rs.next())
			e = new Employee(rs.getInt("id"),rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("country"));
		rs.close();
		stmt.close();
		return e;
	}

	public static void updateQuery(Connection conn,Employee e, int id) throws SQLException{
		stmt = conn.createStatement();
		String sql = "UPDATE employee SET id="+e.getId()+",name='"+e.getName()+"',password='"+e.getPwd()+"',email='"+e.getEmail()+"',country='"+e.getCountry()+"' WHERE id = "+id;
		stmt.execute(sql);
		stmt.close();
	}
}
