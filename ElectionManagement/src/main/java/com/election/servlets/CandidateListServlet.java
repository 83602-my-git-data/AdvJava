package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;
import com.election.pojos.User;

@WebServlet("/candidateList")
public class CandidateListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(CandidateDao cd = new CandidateDaoImpl();) {
			  List<Candidate> list = cd.findAll();
			  resp.setContentType("text/html");
			  PrintWriter out = resp.getWriter();
			  HttpSession session = req.getSession();
			  User user = (User)session.getAttribute("user");
			  out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidates</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3>Online Voting</h3>");
				out.printf("<h3> Name Of Voter is %s </h3>", user.getFirst_name());
				out.println("<form method='post' action='vote'>");
				for (Candidate c : list) {
					out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n", 
							c.getId(), c.getName(), c.getParty());
				}
				out.println("<input type='submit' value='Vote'/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			 
		} catch (Exception e) {
			System.out.println("error in candidate list servlets");
		}
	}
}
