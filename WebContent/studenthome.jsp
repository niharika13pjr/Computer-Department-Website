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
    font-size: 12px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    width:160px;
    height:50px;
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

.button2 {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

.button2:hover {
    background-color: #008CBA;
    color: white;
}

.button3 {
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
}

.button3:hover {
    background-color: #f44336;
    color: white;
}

.button4 {
    background-color: white;
    color: black;
    border: 2px solid #f1c40f;
}

.button4:hover {background-color: #f1c40f;}

.button5 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
}

.button5:hover {
    background-color: #555555;
    color: white;
}
.button6 {
    background-color: white;
    color: black;
    border: 2px solid #34495e;
}

.button6:hover {
    background-color: #34495e;
    color: white;
}
.button7 {
    background-color: white;
    color: black;
    border: 2px solid #8e44ad;
}

.button7:hover {
    background-color: #8e44ad;
    color: white;
}
.button8 {
    background-color: white;
    color: black;
    border: 2px solid #e74c3c;
}

.button8:hover {
    background-color: #e74c3c;
    color: white;
}
.button9 {
    background-color: white;
    color: black;
    border: 2px solid #3498db;
}

.button9:hover {
    background-color: #3498db;
    color: white;
}
.buttons{float:left;}
</style>
</head>


<body>
 <h1>Hello ${userfname} </h1>
 <div class="buttons">
 <a href="studentcourse.jsp"> <button class="button button2">Courses</button></a><br>
 <a href="resource.jsp"><button class="button button1">Resources</button></a><br>
<a href="cancelresource.jsp"><button class="button button7">Cancel Resource</button></a><br>
 <a href="listphd1.jsp"> <button class="button button3">Ph.D student</button></a><br>
 <a href="regexam.jsp"><button class="button button6">Exams</button></a><br>
<a href="result.jsp"><button class="button button7">Exam Results</button></a><br>
<a href="programreq.jsp"><button class="button button9">Program Requirements</button></a><br>
<a href="/termproject/searchdiscussServlet"><button class="button button8">Discussion Board</button></a><br>
<a href="editprofile.jsp"><button class="button button4">Edit Profile</button></a><br>
<a href="/termproject/logout"><button class="button button9">Logout</button></a><br>
</div>
</body>

</html>