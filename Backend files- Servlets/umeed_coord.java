import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class umeed_coord extends HttpServlet
{
	static final String JDBC_Driver="oracle.jdbc.driver.OracleDriver";
	static final String DB_URL="jdbc:oracle:thin:@localhost:1521:XE";
	static final String user="system";
	static final String pass="manager";
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		Connection c;
		PreparedStatement ps;
		String uname=req.getParameter("nm");
		String pas=req.getParameter("pwd");
		String em=req.getParameter("eid");
		long phone=Long.parseLong(req.getParameter("contact"));
		String address=req.getParameter("add");
		String ino= req.getParameter("idno");
		String sc= req.getParameter("sch");
		try
		{
			Class.forName(JDBC_Driver);
			
			c=DriverManager.getConnection(DB_URL,user,pass);
			
			ps=c.prepareStatement("insert into umeed_coord values(?,?,?,?,?,?,?)");
				ps.setString(1,uname);
				ps.setString(2,pas);
				ps.setString(3,em);
				ps.setLong(4,phone);
				ps.setString(5,address);
				ps.setString(6,ino);
				ps.setString(7,sc);
				int i=ps.executeUpdate();
			c.commit();
			ps.close();
			c.close();
			res.sendRedirect("http://"+req.getServerName()+":"+req.getServerPort()+"/Umeed/coord.html");
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
