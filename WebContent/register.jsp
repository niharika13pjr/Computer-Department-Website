<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function a() {
		var x = document.getElementById("pd");
		var y = document.getElementById("rpd");
		submitok = "true";
		if (x.value == "") {
			alert("Enter Password");
			submitok = "false";
		}
		if (y.value == "") {
			alert("Enter Re-type Password");
			submitok = "false";
		}
		if (x.value != y.value) {
			alert("Password and  Re-type Password are not match");
			submitok = "false";
		} else {
			window.location.reload();
		}
	}
	
	
</script>
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
</head>
<div class="header">
<%@ include file="header.jsp" %>
</div>
<body>

<div class="container">

  <h2><div align="center">Register Here !</div></h2>
 
    
<form action="RegistrationServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
							<div class="container">
							<br/>
							<table>
								<tr>
									<td>First Name*</td>
									<td><input class="form-control" type="text"
										placeholder="First Name"  name="fname" class="input-group col-md-7"></td>
								</tr>
								
								<tr>
									<td>Last Name*</td>
									<td><input class="form-control" type="text"
										placeholder="Last Name" name="lname"  class="input-group col-md-7"></td>
								</tr>
								
								
								<tr>
									<td>netID*</td>
									<td><input class="form-control" type="text"
										placeholder="netID" name="netID" ></td>
								</tr>
  								<tr>
									<td>Password*</td>
									<td><input class="form-control" type="password"
										placeholder="Password" id="pd" name="password" ></td>
								</tr>
								<tr>
									<td>Re-type Password</td>
									<td><input class="form-control" type="password"
										placeholder="Re-type Password" id="rpd" name="rpd"></td>
								</tr>
								<tr>
									<td>I am*:</td>
									<td><input class="" type="radio" name="iam" value="student" checked="checked" onclick="show();" >Student
										<input class="" type="radio" name="iam" value="staff" onclick="hide();">Staff
										<input class="" type="radio" name="iam" value="faculty" onclick="hide();">Faculty</td>
								</tr>
<tr>


<td>Year Joined*</td>

<td><input class="form-control" type="text" 

placeholder="Year joined" name="year" ></td>

</tr>

<tr>

<td>Program* :</td>

<td><input class="" type="radio" name="program" value="bs" checked="checked" name="Textbox2">BS

<input class="" type="radio" name="program" value="ba">BA

<input class="" type="radio" name="program" value="ms">MS

<input class="" type="radio" name="program" value="phd">Ph.D</td>

</tr>
  <tr>


<td>Major*</td>

<td><input class="form-control" type="text" 

placeholder="Major" name="major" ></td>

</tr>   

								
	
								</table>
								
										</div>	
											
											<input type="submit" class="button button1" value="Register">
											</div>
											</form>
						</div>
					
		<div align="center">				<a href="login.jsp">Return to home page</a></div>
						
</body>
</html>