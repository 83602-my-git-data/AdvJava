package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.pojos.User;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		  User user = (User)session.getAttribute("user");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("Goodbye, %s<hr/>\n", user.getFirst_name());
		session.invalidate();
		
		out.println("Thank you for saving democracy. <br/><br/>");
		out.println("<a href='index.html'>Login Again</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
