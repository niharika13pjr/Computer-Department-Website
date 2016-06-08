<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</style>
</head>
<body>
<br><br><br>
<form>
<div align="center">
<div class="form-group">

							
							<div class="container">
							
<table>
<tr>
									<td>Enter email: </td>
									<td><input class="form-control" type="text"
										placeholder="Email" name="email"></td>
								</tr>
								</table>
<a href="test.jsp">Send Email</a><br/><br/><br/>
<a href="login.jsp">Return to login</a>
</div></div></div>
</form>
</body>
</html>