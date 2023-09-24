<%@ page import="db.DBConnection" %>
<%@ page import="com.bank.User" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Connection con = DBConnection.connect();
String query ="delete from banking where id=?";
int id = Integer.parseInt(request.getParameter("id"));
PreparedStatement stmt = con.prepareStatement(query);
stmt.setInt(1, id);
int i= stmt.executeUpdate();

if(i>0)
{
response.sendRedirect("alluser.jsp");	
}
else
{
response.sendRedirect("delete.jsp");	
}
%>


</body>
</html>