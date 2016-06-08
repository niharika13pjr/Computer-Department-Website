<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<%@ include file="header.jsp" %>

</head>
<style>
form { 
margin: 0 auto; 
width:250px;
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
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}

</style>
<body>
<%@ include file="facultyhome.jsp" %>
<h3>EDIT !</h3>
<form action="CourseEditServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
							<div class="container">
							
<table>
<tr>
									<td>Course ID</td>
									<td><input class="form-control" type="text"
										placeholder="Course ID" name="courseID"></td>
								</tr>

  								<tr>
									<td>Professor Office Details</td>
									<td><input class="form-control" type="textarea"
										placeholder="Professor Office Details" name="profoffcdetails"></td>
								</tr>
								<tr>
								
									<td>TA Office Details</td>
									<td><input class="form-control" type="textarea"
										placeholder="TA Office Detail" name="taofficedetails"></td>
								</tr>
								<tr>
									<td>Course Syllabus</td>
									<td><input class="form-control" type="textarea"
										placeholder="Course Syllabus" name="coursesyllabus"></td>
								</tr>
								</table>
								
<a href="listcourse.jsp"><input type="submit" class="button button1" name="List of Courses" value="editpost"></a><br/>
</div></div>	
											</form>
						

</body>
<%@ include file="footer.jsp" %>
</html>