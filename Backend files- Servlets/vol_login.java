import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class  vol_login extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

		out.println("<html><head><title>Login</title></head><body>");
		
		String username=request.getParameter("nm");
		String password=request.getParameter("pwd");

		Connection con=null;
		Statement stmt=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url="jdbc:oracle:thin:@localhost:1521:XE";
			con=DriverManager.getConnection(url,"system","manager");
			stmt=con.createStatement();

			if(!con.isClosed())
			{
				String query="select nm,pwd from umeed_volunteer where nm='"+username+"' and pwd='"+password+"'";
				ResultSet rs=stmt.executeQuery(query);
				

				if(rs.next())	
					response.sendRedirect("http://"+request.getServerName()+":"+request.getServerPort()+"/Umeed/volunteer_page");
 			else
					out.println("Wrong User Name and Password");
				
			}
			stmt.close();
			con.close();
			
		}
		catch (Exception e)
		{
			out.println(e.getMessage());
		}
		out.println("</body></html>");
		out.close();
	}
}
