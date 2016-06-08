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
<style>
form { 
margin: 0 auto; 
width:250px;
}
h3 {
    text-align: left;
}

</style>
</head>
<body>
<%@ include file="facultyhome.jsp" %>
<form action="deletedeptExamServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
							<div class="container">
							<h3>Delete Result Exam</h3><br><br>
							<table>
								<tr>
									<td>Exam Name</td>
									<td><input class="form-control" type="text"
										placeholder="Course ID" name="dexamname"></td>
								</tr>
								</table>
								<h5>Results </h5>
								<table>
								<tr>
									<td>Student ID</td>
									<td><input class="form-control" type="text"
										placeholder="Course Name" name="studentexamID"></td>
								</tr>
  								
								</table>
									
										
											<input type="submit" class="button button1" value="Delete Result">
											
											</div>
											</div>
											</form>
			
						
</body>
<%@ include file="footer.jsp" %>
</html>