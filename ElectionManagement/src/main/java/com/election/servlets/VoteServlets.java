package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.dao.UserDao;
import com.election.dao.UserDaoImpl;
import com.election.pojos.User;

@WebServlet("/vote")
public class VoteServlets extends HttpServlet {
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		HttpSession session = req.getSession();
		  User user = (User)session.getAttribute("user");
	    System.out.println(user);
	    String message = "";
		try(UserDao ud = new UserDaoImpl(); CandidateDao cd = new CandidateDaoImpl();){
			if(!user.isStatus()) {
				int id = Integer.parseInt(req.getParameter("candidate"));
				cd.incrementVotes(id);
				ud.updateStatus(user.getId(), true);
				message = "Your vote is registerd successfully. <br/><br/>";
			}
			else {
				message = "Your vote is all ready registerd successfully. <br/><br/>";
			}
		} catch (Exception e) {
			System.out.println("in VoteServlets");
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Online Voting</h3>");
		
		out.printf("Hello, %s<hr/>\n", user.getFirst_name());
		out.println(message);
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
