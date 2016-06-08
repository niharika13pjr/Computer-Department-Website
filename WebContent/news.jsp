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
<body>
<br>
<%@ include file="facultyhome.jsp" %>
<div class="container">
<form action="jobaddServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

<table>
<tr>
									<td>News ID</td>
									<td><input class="form-control" type="text"
										placeholder="ID" name="newsID"></td>
								</tr>

  								<tr>
									<td>Name</td>
									<td><input class="form-control" type="text"
										placeholder="News Name" name="newsname"></td>
								</tr>
								<tr>
								
									<td>Detail</td>
									<td><input class="form-control" type="textarea"
										placeholder="links" name="newsdetail"></td>
								</tr>
								
								</table>
									
	<div align="center"><input type="submit" class="button button1" name="List of alumni" value="Add">
									</div></div>		</form>
								
			<div align="center">
						<a href="editnews.jsp"><input type="submit" class="button button1" value="Edit"></a>	<br>
			<a href="deletenews.jsp"><input type="submit" class="button button1" value="Delete"></a></div>
	
	
</div>

</body>
<%@ include file="footer.jsp" %>
</html>