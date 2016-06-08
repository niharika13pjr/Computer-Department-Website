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
<%@ include file="studenthome.jsp" %>
<form action="editprofileServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
							<div class="container">
							<h2>Edit Profile</h2>
							
<table>
<tr>
									<td>netID</td>
									<td><input class="form-control" type="text"
										placeholder="Name" name="netID"></td>
								</tr>

  								<tr>
									<td>Advisor Details: </td>
						<td><input class="form-control" type="textarea"
										placeholder="links" name="advisordetail"></td>
										
								</tr>
								<tr>
								
									<td>Phone</td>
									<td><input class="form-control" type="text"
										placeholder="links" name="phone"></td>
								</tr>
								<tr>
								
									<td>Email</td>
									<td><input class="form-control" type="text"
										placeholder="links" name="email"></td>
								</tr>
								</table>
							
<a href="editedprofile.jsp"><input type="submit" class="button button1" name="Edit profile" value="Edit profile"></a><br/>
</div>	</div>	
											</form>
						

</body>
<%@ include file="footer.jsp" %>
</html>