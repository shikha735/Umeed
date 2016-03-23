import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class admin_page extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

		// HTML content
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Umeed</title>");
		out.println("<script type='text/javascript' src='jquery_min.js'></script>");
		out.println("<script type='text/javascript' src='jquery.slidertron-1.1.js'></script>");
		out.println("<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700' rel='stylesheet' type='text/css'>");
		out.println("<link href='style.css' rel='stylesheet' type='text/css' media='all' />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='header' class='container'>");
		out.println("<div id='logo'>");
		out.println("<h1><a href='index.html'>Umeed</a></h1>");
		out.println("</div>");
		out.println("<div id='menu'>");
		out.println("<ul>");
		out.println("<li class='dropdown'><a href='#' accesskey='1'  class='dropbtn' title=''>Login</a>");
       	out.println("<div class='dropdown-content'>");
		out.println("<a href='admin.html'>Admin</a>");
      	out.println("<a href='coord.html'>Coordinator</a>");
      	out.println("<a href='volunteer.html'>Volunteer</a>");
    	out.println("</div>");
        out.println("</li>");
		out.println("<li class='dropdown'><a href='#' class='dropbtn' accesskey='2' title=''>Registration</a>");
    	out.println("<div class='dropdown-content'>");
		out.println("<a href='radmin.html'>Admin</a>");
      	out.println("<a href='rcoord.html'>Coordinator</a>");
      	out.println("<a href='rvolunteer.html'>Volunteer</a>");
    	out.println("</div>");
        out.println("</li>");
		out.println("<li><a href='schools.html' accesskey='3' title=''>Schools</a></li>");
		out.println("<li><a href='activities.html' accesskey='4' title=''>Activities</a></li>");
        out.println("<li><a href='query.html' accesskey='3' title=''>Query</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div id='page' class='container'>");
		out.println("<div id='content'>");
		out.println("<div id='onecolumn'><h2>Welcome Admin!!</h2>");
		out.println("</div><br /><br />");
		
		
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
				String query="select nm,sch from umeed_coord";
				ResultSet rs=stmt.executeQuery(query);
				out.println("<h3>List of coordinators</h3>");
				out.println("<table>");

				while(rs.next())	
				{
					out.println("<tr><td>" + rs.getString(1) + "</td>");
					out.println("<td>" + rs.getString(2) + "</td></tr>");
				}		
				out.println("</table>");
				
			}
			stmt.close();
			con.close();
			
		}
		catch (Exception e)
		{
			out.println(e.getMessage());
		}
		
		out.println("</div>");
		out.println("</div>");

		out.println("<div id='copyright' class='container'>");
		out.println("<p>&copy; Umeed. All rights reserved. Design by Shikha and Sivani");
		out.println("</div>");
		out.println("</body></html>");
		
		out.close();
	}
}
