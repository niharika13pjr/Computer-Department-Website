<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ page import="java.sql.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.wrapper {
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
    font-size: 12px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    width:160px;
    height:50px;
    
}
.button5 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
}

.button5:hover {
    background-color: #555555;
    color: white;
}
.button6 {
    background-color: white;
    color: black;
    border: 2px solid #1abc9c;
}

.button6:hover {
    background-color: #1abc9c;
    color: white;
}
.button7 {
    background-color: white;
    color: black;
    border: 2px solid #8e44ad;
}

.button7:hover {
    background-color: #8e44ad;
    color: white;
}
form { 
margin: 10px auto; 
width:1000px;
}
h3 {
    text-align: center;
}
</style>

<%@ include file="header.jsp" %>

</head>
<body>
<%@ include file="facultyhome.jsp" %>
<h3>Announcements !</h3>

<div class="buttons">
<div class="wrapper">
<a href="job.jsp"><button class="button button5">Jobs</button></a>
<a href="event.jsp"><button class="button button6">Events</button></a>
<a href="news.jsp"><button class="button button7">News</button></a><br></div>
 <br><br>
<table border="1" width="90%" height="30%" align="center">
<tr><th><font color='Red'>Job name</font></th>
<th><font color='Red'>Job type</font></th>
<th><font color='Red'>Job link</font></th>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdept","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from job");
  while(rs.next())
  {
      String jobname=rs.getString("jobname");
      String jobtype=rs.getString("jobtype");
      String joblink=rs.getString("joblink");
  %>
<tr>
<td><b><%=jobname%></b></td>
<td><b><%=jobtype%></b></td>
<td><a href="https://www.eurocarparks.com/job-vacancies"><b><%=joblink%></b></a></td>
</tr>
<%
  }
 %>
 </table>
  <br><br>
 <table border="1" width="60%" height="30%" align="center">
<tr><th><font color='Red'>NewsID</font></th>
<th><font color='Red'>News name</font></th>
<th><font color='Red'>News detail</font></th>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdept","root","root");
Statement stmt1=con.createStatement();
ResultSet rs1=stmt.executeQuery("select * from news");
  while(rs1.next())
  {
      String newsID=rs1.getString("newsID");
      String newsname=rs1.getString("newsname");
      String newsdetail=rs1.getString("newsdetail");
  %>
<tr>
<td><b><%=newsID%></b></td>
<td><b><%=newsname%></b></td>
<td><b><%=newsdetail%></b></td>
</tr>
<%
  }
 %>
 </table>
 <br><br>
 <table border="1" width="60%" height="30%" align="center">
<tr><th><font color='Red'>Event ID</font></th>
<th><font color='Red'>Event name</font></th>
<th><font color='Red'>Event Detail</font></th>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdept","root","root");
Statement stmt2=con.createStatement();
ResultSet rs2=stmt.executeQuery("select * from event");

  while(rs2.next())
  {
      String eventID=rs2.getString("eventID");
      String eventname=rs2.getString("eventname");
      String eventdetail=rs2.getString("eventdetail");
  %>
<tr>
<td><b><%=eventID%></b></td>
<td><b><%=eventname%></b></td>
<td><b><%=eventdetail%></b></td>
</tr>
<%
  }
 %>
 </table>
  <br><br>
<br>

</div>

</body>

</html>