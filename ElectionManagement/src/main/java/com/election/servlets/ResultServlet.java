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
			List<Candidate> list = cd.findAll();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Candidate Information</title>");
			out.println("<style>");
			out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;}");
			out.println(".container {width: 80%; margin: 50px auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1);}");
			out.println("h1 {text-align: center; color: #333;}");
			out.println("table {width: 100%; border-collapse: collapse; margin: 20px 0;}");
			out.println("table, th, td {border: 1px solid #ddd;}");
			out.println("th, td {padding: 8px; text-align: center;}");
			out.println("th {background-color: #f2f2f2;}");
			out.println("a {color: #4CAF50; text-decoration: none;}");
			out.println("a:hover {text-decoration: underline;}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class='container'>");
			out.println("<h1>Candidate Information</h1>");
			out.println("<table>");
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
				//out.printf("<a href='delete/%d'>Delete</a>",candidate.getId());
				out.println("<a href=''>Delete</a>");
				out.println(" | ");
				out.println("<a href=''>Update</a>");
				out.println("</td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("<div style='text-align: center; margin-top: 20px;'>");
			out.println("<a href='announce'>Announce</a> ");
			out.println("<a href='logout'>SignOut</a>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}

//package com.election.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.election.dao.CandidateDao;
//import com.election.dao.CandidateDaoImpl;
//import com.election.pojos.Candidate;
//
//public class ResultServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		try(CandidateDao cd = new CandidateDaoImpl();) {
//			   List<Candidate> list  = cd.findAll();
//			   resp.setContentType("text/html");
//				PrintWriter out = resp.getWriter();
//				out.println("<head>");
//				out.println("<title>Candidate Information</title>");
//				out.println("</head>");
//				out.println("<h1 style='center'>Candidate Information</h1>");
//			    out.println("<table style = 'center' border='10'>");
//			    out.println("<tr>");
//			    out.println("<th>ID</th>");
//			    out.println("<th>Votes</th>");
//			    out.println("<th>Name</th>");
//			    out.println("<th>Party</th>");
//			    out.println("<th>Actions</th>");
//			    out.println("</tr>");
//
//			    for (Candidate candidate : list) {
//			        out.println("<tr>");
//			        out.println("<td>" + candidate.getId() + "</td>");
//			        out.println("<td>" + candidate.getVotes() + "</td>");
//			        out.println("<td>" + candidate.getName() + "</td>");
//			        out.println("<td>" + candidate.getParty() + "</td>");
//			        out.println("<td>");
//			        out.println("<a href=''>Delete</a>");
//			        out.println(" | ");
//			        out.println("<a href= ''>Update</a>");
//			        out.println("</td>");
//			        out.println("</tr>");
//			    }
//
//			    out.println("</table>");
//			    out.println("<a href=''>Announce</a> <a href='logout'>SignOut</a> ");
//				
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new ServletException(e);
//		}
//	}
//}
