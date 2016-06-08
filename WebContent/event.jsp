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
}</style>
</head>

<br>
<%@ include file="facultyhome.jsp" %>
<div class="container">
<form action="jobaddServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

<table>
<tr>
									<td>EventID</td>
									<td><input class="form-control" type="text"
										placeholder="ID" name="eventID"></td>
								</tr>

  								<tr>
									<td>Name</td>
									<td><input class="form-control" type="text"
										placeholder="Event Name" name="eventname"></td>
								</tr>
								<tr>
								
									<td>Detail</td>
									<td><input class="form-control" type="textarea"
										placeholder="links" name="eventdetail"></td>
								</tr>
								
								</table>
							
	
											
	<div align="center"><input type="submit" class="button button1" name="List of alumni" value="Add">
									</div></div>		</form>
								
			<div align="center">
						<a href="editevent.jsp"><input type="submit" class="button button1" value="Edit"></a>	<br>
			<a href="deleteevent.jsp"><input type="submit" class="button button1" value="Delete"></a></div>
	
	
</div>

</body>
<%@ include file="footer.jsp" %>
</html>