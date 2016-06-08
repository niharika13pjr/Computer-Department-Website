<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.offscreen { 
  position: absolute; 
  top: -30em; 
  left: -300em; 
} 

div#vmenu { 
   margin: 0; 
   padding: .25em 0em .25em 0em; 
   border: solid 1px #30c9e0; 
   background: #fcac4c; 
   width: 13.5em; 
} 

div#vmenu ul { 
   margin: 0; 
   padding: 0; 
   list-style: none; 
} 

div#vmenu ul li { 
   margin: 0; 
   padding: 0; 
   list-style: none; 
} 

div#vmenu ul a:link { 
   margin: 0; 
   padding: .2em 0em .2em .4em; 
   text-decoration: none; 
   font-weight: bold; 
   font-size: medium; 
   background-color: #fcac3c; 
   color: #0059a0; 
   display: block; 
} 

div#vmenu ul a:active { 
   margin: 0; 
   padding: .25em .5em .25em .5em; 
   text-decoration: none; 
   font-weight: bold; 
   font-size: medium; 
   background: #4d8cba; 
   color: #ffffff; 
   display: block; 
} 

div#vmenu ul a:visited { 
   margin: 0; 
   padding:  .25em .5em .25em .5em; 
   text-decoration: none; 
   font-weight: bold; 
   font-size: medium; 
   background: #4d8cba; 
   color: #ffffff; 
   display: block; 
} 

div#vmenu ul li a:hover { 
   margin: 0; 
   padding: .2em 0em .2em .4em; 
   text-decoration: none; 
   font-weight: bold; 
   font-size: medium; 
   background-color: #30c9e0; 
   color: #ffffff; 
   display: block; 
} 
</style>
</head>

<body>
<h2 class="offscreen">W3C Web Resources</h2> 
<div id="vmenu"> 
 <div class="buttons">
<a href="resource.jsp"><button class="button button1">Resources</button></a><br>
<a href="listcourse.jsp"> <button class="button button2">Courses</button></a><br>
<a href="listphd.jsp"> <button class="button button3">Ph.D student</button></a><br>
<a href="announcement.jsp"><button class="button button4">Announcements</button></a><br>
<a href="listalumni.jsp"><button class="button button5">Alumni</button></a><br>
<a href="addexam.jsp"><button class="button button6">Exams</button></a><br>
<a href="deptexam.jsp"><button class="button button7">Department Exams</button></a><br>
<a href="/termproject/searchdiscussServlet"><button class="button button8">Discussion Board</button></a><br>
<a href="/termproject/logout"><button class="button button9">Logout</button></a><br>
</div> 
</div>
</body>

</html>
