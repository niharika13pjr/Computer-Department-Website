<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<%@ include file="header.jsp" %>

<style>
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
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}
form { 
margin: 0 auto; 
width:250px;
}
h3 {
    text-align: left;
}
</style>
<body>
<%@ include file="studenthome.jsp" %>
<%HttpSession sRes=request.getSession();
Integer uid=(Integer)sRes.getAttribute("userID");%>
<form action="regexamServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

<td> <input type="hidden" value=<%=uid %> name="userID"></td>
							
							<div class="container">
							<h3>Register for Exam</h3><br><br>
							<table>
							
							<tr>
									<td>Student ID</td>
									<td><input class="form-control" type="text"
										placeholder="ID" name="studentexamID"></td>
								</tr>
								<tr>
									<td>Exam Name</td>
									<td><input class="form-control" type="text"
										placeholder="Exam name" name="examname"></td>
								</tr>
								
							
								</table>
								<input type="submit" class="button button1" value="Done">
								</div></div>
										</form>
											
			<br>
								</body>
<%@ include file="footer.jsp" %>
</html>