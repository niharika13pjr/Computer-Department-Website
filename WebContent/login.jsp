<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<style type="text/css">


pre {
  
    font-family: comic sans ms;
    
    
} 
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<body>
<div class="container">
<div align="center">
<h1>Welcome to Computer Department Website</h1>

<form action="LoginServlet">
<form class="form-horizontal" role="form">
<h5>Please enter details</h5>
<pre>

netID :    <input class="form-control"  name="netID" placeholder="netID"><br>
Password : <input class="form-control"  type="password" name="pd" placeholder="Password"><br>
I am :	<input class="" type="radio" name="iam" value="staff" checked>Staff    <input class="" type="radio" name="iam" value="faculty" >Faculty     <input class="" type="radio" name="iam" value="student">Student
<%

							if (request.getAttribute("error") == null || request.getAttribute("error").equals(""))
							{
								//out.print("First Time<br>");
							}
							else
							{
								//out.print("2nd Time");
								String Error = (String) request.getAttribute("error");
								//out.print(Error);
								
								if ((Error.equalsIgnoreCase("usernotfound")))
								{
									out.print("<font color=red>User is not Registered.</font> <br>");
								}
								else if ((Error.equalsIgnoreCase("invalidpassowrd")))
								{
									out.print("<font color=red>Password is Incorrect.</font><br>");
								}
							}
                          %>   </pre> 
			
								
               
 <button class="btn btn-primary" type="submit">Login <i class="fa fa-fw fa-unlock-alt"></i></button><br><br>
 
<a href="forgotpassword.jsp" class="forgot-password">Forgot password?</a> <br>
 <a href="register.jsp" class="forgot-password">Register Now</a> 

</form></form>
      </div>      </div>     
</body>


<center>

<p>Copyright © 2016</p>
</center>
</html>