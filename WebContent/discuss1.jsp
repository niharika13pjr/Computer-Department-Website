<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="model.discuss"%>  
    <%@page import="java.util.ArrayList"%>  
    <%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function clickFunction(clicked_id)
{
	
	var str=clicked_id;
	var pid=str.substring(6);
	var msg="reply"+pid;
	
	document.getElementById("replyContent").value=document.getElementById(msg).value;
	
	
	document.getElementById("parentid").value=pid;

}
</script>

<%@ include file="header.jsp" %>
<style>
form { 
margin: 0 auto; 
width:250px;
}
h3 {
    text-align: center;
}
</style>

</head>
<body>
<%@ include file="facultyhome.jsp" %>
<%
HttpSession postsession	= request.getSession();
String type=(String)postsession.getAttribute("usertype");
boolean isStudent=false;;
if(type.equals("student"))
isStudent=true;
%>

<br/><br/>
<%
String msg2=(String)request.getAttribute("msg2");
%>
<br>
<form action="discussServlet" method="post">
<input type="text" name="postContent">
<input type="Submit" value="Post">
<%out.write(msg2); %><hr>
<%-- <input type="hidden" name="hash" value=<%=htt.getHashtag() %>>
 --%>
<input type="hidden" id="parentid" name="parentid" value="0">
<input type="hidden" name="replyContent" id="replyContent" value="">
<%if(!isStudent) {%>
<%} %>
<%
@SuppressWarnings("unchecked")
ArrayList<discuss> htf=(ArrayList<discuss>)request.getAttribute("Hashtagvalues");
if(htf.size()<1)
{
	String msg=(String)request.getAttribute("msg");
	if(msg!=null)
	{
	out.write("<br>"+msg);
	}
}
else
{
for(int i=0;i<htf.size();i++)
{
	
	if(htf.get(i).getParentId()==0)
	{
		
		out.write(htf.get(i).getcontent()+"-------"+htf.get(i).getpostedDate()+"<br>");
		%><a href="/termproject/deleteServlet?id=<%=htf.get(i).getId()%>">deletePost</a>
		
		<% 
		
	for(int j=0;j<htf.size();j++)
	{
		if(htf.get(j).getParentId()==htf.get(i).getId())
		{
			out.write("	--> "+htf.get(j).getcontent());%><a href="/termproject/replyServlet?id=<%=htf.get(j).getId()%>">deleteReply</a>
			
			<% 
		}
	}
	%>	
	<input type="text" name="reply<%=htf.get(i).getId()%>" id="reply<%=htf.get(i).getId()%>">
	<input type="submit" name="submit<%=htf.get(i).getId() %>" id="submit<%=htf.get(i).getId() %>" value="Reply" onClick="clickFunction(this.id)"> 
	<hr>
	
<%	
	
	}
}
}
%>
</form>
</body>
<%@ include file="footer.jsp" %>
</html>