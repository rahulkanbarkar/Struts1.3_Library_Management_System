<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 8px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
a:hover, a:active {
  background-color: red;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">
<center>

<h1>Library Managment System</h1>
</center>
<%-- <% String firstname= (String) session.getAttribute("firstname"); %>
<h2>Hi <span><%= firstname %></span></h2> --%>
<a href="./booklist.do">booklist</a><br><br>                                      
<a href="./booklistnew.do">booklist New</a><br><br> 
<a href="addbooks.jsp">Add Books</a><br><br>
<a href="updatebook.jsp">Update Book</a><br><br>
<a href="deletebook.jsp">Delete Book</a><br><br>
<a href="findbook.jsp">Find book</a><br><br>
<a href="logout.jsp">Logout</a><br><br>
<a href="home.jsp"><--Back </a></h3>


</body>
</html>