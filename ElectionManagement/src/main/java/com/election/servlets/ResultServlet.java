package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;

public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try(CandidateDao cd = new CandidateDaoImpl();) {
			   List<Candidate> list  = cd.findAll();
			   resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<h1 style='center'>Candidate Information</h1>");
			    out.println("<table style = 'center' border='10'>");
			    out.println("<tr>");
			    out.println("<th>ID</th>");
			    out.println("<th>Votes</th>");
			    out.println("<th>Name</th>");
			    out.println("<th>Party</th>");
			    out.println("<th>Actions</th>");
			    out.println("</tr>");

			    for (Candidate candidate : list) {
			        out.println("<tr>");
			        out.println("<td>" + candidate.getId() + "</td>");
			        out.println("<td>" + candidate.getVotes() + "</td>");
			        out.println("<td>" + candidate.getName() + "</td>");
			        out.println("<td>" + candidate.getParty() + "</td>");
			        out.println("<td>");
			        out.println("<a href=''>Delete</a>");
			        out.println(" | ");
			        out.println("<a href= ''>Update</a>");
			        out.println("</td>");
			        out.println("</tr>");
			    }

			    out.println("</table>");
				
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
}
