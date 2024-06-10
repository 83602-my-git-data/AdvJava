<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Login Beans</title>
</head>
<body>
   <jsp:useBean id="login" class="com.election.javabeans.LoginBeans"></jsp:useBean>
   <jsp:setProperty property="email" name="login" param="email"/>
   <jsp:setProperty property="password" name="login" param="password"/>
   <% login.loginAuth();%>
   
 <% 
    if (login.getUser() != null && login.getPassword().equals(login.getUser().getPassword()) && login.getUser().getRole().equals("admin")) {
%>
        <h1>Login SuccessFul</h1>
<% 
    } else if (login.getUser() != null && login.getPassword().equals(login.getUser().getPassword()) && login.getUser().getRole().equals("voter")) {
%>
        <h1>Login Failure</h1>
<% 
    } 
%>

</body>
</html>