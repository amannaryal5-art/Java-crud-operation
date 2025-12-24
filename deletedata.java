package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletedata
 */
@WebServlet("/deletedata")
public class deletedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@Venus.seedthane.com:1521/oracle12c.seedthane.com","system","newpassword123");	
	        PreparedStatement ps=conn.prepareStatement("delete from batch0325  where id = ?"); 
	        ps.setInt(1, id);
	      
	        int row=ps.executeUpdate();
	        response.getWriter().print("<h1>the no of row deleted="+row+"</h1>");
	        conn.close();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
