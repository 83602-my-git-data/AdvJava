<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Login Beans</title>
</head>
<body>
   <jsp:useBean id="login" class="com.election.javabeans.LoginBeans" scope="session"></jsp:useBean>
   <jsp:setProperty property="email" name="login" param="email"/>
   <jsp:setProperty property="password" name="login" param="password"/>
   <% login.loginAuth();%>
   
 <% 
    if (login.getUser() != null && login.getPassword().equals(login.getUser().getPassword()) && login.getUser().getRole().equals("admin")) {
%>       
        <% response.sendRedirect("result.jsp"); %>
<% 
    } else if (login.getUser() != null && login.getPassword().equals(login.getUser().getPassword()) && login.getUser().getRole().equals("voter")) {
%>
        <% response.sendRedirect("candidatelist.jsp"); %>
<% 
    } 
%>

</body>
</html>