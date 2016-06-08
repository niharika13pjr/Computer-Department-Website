<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
<%@ include file="header.jsp" %>

</head>

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


form { 
margin: 10px auto; 
width:700px;
}
h3 {
    text-align: center;
}
</style>
<body>
<%@ include file="facultyhome.jsp" %>
<br>

<h3>New Exam offering!!</h3>
<form action="examAddServlet" method="post"
							onsubmit="a()" role="form" >
							<div class="form-group">

							
							<div class="container">
							
<table>
<tr>
									<td>Name</td>
									<td><input class="form-control" type="text"
										placeholder="Name" name="examname"></td>
								</tr>

  								<tr>
									<td>Date</td>
									<td><input class="form-control" type="text"
									id="datepicker"	placeholder="Exam Date" name="examdate"></td>
								</tr>
								<tr>
								
									<td>Links</td>
									<td><input class="form-control" type="textarea"
										placeholder="links" name="examlink"></td>
								</tr>
								
								</table>
								
<a href="success.jsp"><input type="submit" class="button button1" name="List of alumni" value="Add"></a><br/>
</div></div>	
											</form>

						


</body>
<%@ include file="footer.jsp" %>
</html>