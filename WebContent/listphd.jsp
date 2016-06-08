<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ page import="java.sql.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%@ include file="header.jsp" %>

</head>
<style>
form { 
margin: 10 auto; 
width:700px;
}
h3 {
    text-align: center;
}
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 10px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    align: center;
}
.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #c0392b;
}
.button1:hover {
    background-color: #c0392b;
    color: white;
}
</style>
<body>
<%@ include file="facultyhome.jsp" %>
<h3>List of Ph.D Students</h3>
<table border="1" width="40%" height="30%" align="center">
<tr><th><font color='Red'>First Name</font></th>
<th><font color='Red'>Last Name</font></th>
<th><font color='Red'>Status</font></th>
<th><font color='Red'>Advisor Detail</font></th>
<th><font color='Red'>Number of Semester</font></th>
</tr>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdept","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from Registration where program='phd'");
  while(rs.next())
  {
      String fname=rs.getString("fname");
      String lname=rs.getString("lname");
      String candidate=rs.getString("candidate");
      String advisordetail=rs.getString("advisordetail");
      String sem=rs.getString("sem");
  %>
<tr>
<td><b><%=fname%></b></td>
<td><b><%=lname%></b></td>
<td><b><%= candidate %></b></td>
<td><b><%= advisordetail %></b></td>
<td><b><%= sem %></b></td>

</tr>
<%
  }
 %>
 </table>
<br/>
<div align="center">
<a href="phdupdate.jsp"><input type="submit" class="button button1" value="Update" ></a><br/>
</div>


</body>
<%@ include file="footer.jsp" %>
</html>