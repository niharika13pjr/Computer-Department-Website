<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style type="text/css">
form { 
margin: 10px auto; 
width:500px;
}
h3 {
    text-align: left;
}</style>
</head>
<body>
<%@ include file="facultyhome.jsp" %>
<form action="deletejobServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
							<div class="container">
							<h3>Delete</h3><br><br>
<table>
<tr>
									<td>Job Name</td>
									<td><input class="form-control" type="text"
										placeholder="Name" name="jobname"></td>
								</tr>

  								<!-- <tr>
									<td>Job type : </td>
						<td><input class="" type="radio" name="jobtype" value="on-campus" checked="checked">On-campus
										<input class="" type="radio" name="jobtype" value="off-campus">Off-campus
										
								</tr>
								<tr>
								
									<td>Link</td>
									<td><input class="form-control" type="textarea"
										placeholder="links" name="joblink"></td>
								</tr> -->
								
								</table>
							
							<input type="submit" class="button button1" value="Delete">
								</div>
							</div>
								</form>
</body>
<%@ include file="footer.jsp" %>
</html>