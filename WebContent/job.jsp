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
</head>
<body>
<br>
<%@ include file="facultyhome.jsp" %>
<div class="container">
<form action="jobaddServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

<table>
<tr>
									<td>Job Name</td>
									<td><input class="form-control" type="text"
										placeholder="Name" name="jobname"></td>
								</tr>

  								<tr>
									<td>Job type : </td>
						<td><input class="" type="radio" name="jobtype" value="on-campus" checked="checked">On-campus
										<input class="" type="radio" name="jobtype" value="off-campus">Off-campus
										
								</tr>
								<tr>
			
									<td>Link</td>
									<td><input class="form-control" type="textarea"
										placeholder="links" name="joblink"></td>
								</tr>
								
								</table>
							
	
											
	<div align="center"><input type="submit" class="button button1" name="List of alumni" value="Add">
									</div></div>		</form>
								
			<div align="center">
						<a href="editjob.jsp"><input type="submit" class="button button1" value="Edit"></a>	<br>
			<a href="deletejob.jsp"><input type="submit" class="button button1" value="Delete"></a></div>
	
	
</div>

</body>
<%@ include file="footer.jsp" %>
</html>