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
<body>
<%@ include file="studenthome.jsp" %>
<table border="1" width="50%" height="30%" align="center">
<tr>
<th><font color='Red'>Exam name</font></th>
<th><font color='Red'>Date</font></th>
<th><font color='Red'>Link</font></th>

</tr>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csdept","root","root");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from exam");
  while(rs.next())
  {
      String examname=rs.getString("examname");
      String examdate=rs.getString("examdate");
      String examlink=rs.getString("examlink");
     
  %>
<tr>
<td><b><%=examname%></b></td>
<td><b><%=examdate%></b></td>
<td><b><%=examlink%></b></td>


</tr>
<%
  }
 %>
 </table>
 <br><br>
 <div align="center">
<a href="registerforexam.jsp"><input type="submit" class="button button1" value="Register for exam"></a>

</div>

</body>
<%@ include file="footer.jsp" %>
</html>