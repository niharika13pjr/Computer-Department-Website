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

</head>
<style>
form { 
margin: 10px auto; 
width:700px;
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
<form action="UpdatePhdServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
							<div class="container">
							
<table>
<tr>
									<td>First name</td>
									<td><input class="form-control" type="text"
										placeholder="Status" name="fname"></td>
								</tr>
<tr>
									<td>Status</td>
									<td><input class="form-control" type="text"
										placeholder="Status" name="candidate"></td>
								</tr>
  								
								</table>
							
<a href="listphd.jsp"><input type="submit" class="button button1" name="List of Ph.d students" value="phdupdate"></a><br/>
</div>
											</form>
						

	</div>	

</body>
<%@ include file="footer.jsp" %>
</html>