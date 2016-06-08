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
margin: 10px auto; 
width:800px;
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
<br><br>
<%@ include file="studenthome.jsp" %>
<table border="1" width="50%" height="30%" align="center">
<tr>
<th><font color='Red'>userID</font></th>
<th><font color='Red'>First Name</font></th>

<th><font color='Red'>email</font></th>
<th><font color='Red'>year</font></th>
<th><font color='Red'>program</font></th>
</tr>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdept","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from registration where userID='2'");
  while(rs.next())
  {
      String userID=rs.getString("userID");
      String fname=rs.getString("fname");
      String email=rs.getString("email");
      String year=rs.getString("year");
      String program=rs.getString("program");
     
  %>
<tr>
<td><b><%=userID%></b></td>
<td><b><%=fname%></b></td>
<td><b><%=email%></b></td>
<td><b><%=year%></b></td>
<td><b><%=program%></b></td>


</tr>
<%
  }
 %>
 </table>


</body>
<%@ include file="footer.jsp" %>
</html>