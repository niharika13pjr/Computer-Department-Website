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
</head>
<div class="header">
<%@ include file="header.jsp" %>
</div>
<body>
<%HttpSession sRes=request.getSession();
Integer uid=(Integer)sRes.getAttribute("userID");%>
<%@ include file="facultyhome.jsp" %>
<form action="ResourceServlet" method="post"
							onsubmit="a()" role="form">
							<div class="form-group">

							
<table>
<br/><br/>
<tr>

<td> <input type="hidden" value=<%=uid %> name="userID"></td>

</tr>
<tr>
<td>Resource type :</td>
<td><input class="" type="radio" name="resourcetype" value="Conference Room" checked="checked">Conference Room
	<input class="" type="radio" name="resourcetype" value="Projector">Projector</td>
</tr>
<tr>
									<td>Date</td>
									<td><input class="form-control" type="text"
									 id="datepicker" placeholder="Date" name="resourcedate"></td>
								</tr>
<tr>
				<td>SLots:</td>
				<td><select name="slotID">
  <option value="1">8-10</option>
  <option value="2">10-12</option>
  <option value="3">2-3</option>
  <option value="4">4-5</option>
</select></td>

</tr>
								
							
</table>
<input type="submit" class="button button1" value="Reserve">
</div>
</form>
</body>
<%@ include file="footer.jsp" %>
</html>