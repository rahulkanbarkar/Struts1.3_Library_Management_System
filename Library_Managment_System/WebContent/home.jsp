<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<style>
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 6px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
a:hover, a:active {
  background-color: #90EE90;
}
h1 {
     border: 5px solid black; 
      text-align: center;  
    width: 100%;
    font-size: 30pt;
}


</style>
</head>

<%-- <h1>BOOK STATUS</h1>
<html:errors />
<html:form  action="datelist"  method="post"  >
<pre>
<bean:message key="bookid"/>    <html:text property="bookid"/>
<html:submit property="datelist">   <bean:message key="datelist"/></html:submit>

</pre>
</html:form>
<h3><a href="home.jsp"><--Back </a></h3> --%>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">
<center>

<h1>Library Managment System</h1>
</center>
<%-- <% String name= (String) session.getAttribute("userid"); %>
<h2>Hi <span><%= name %></span></h2> --%>
 
 <a href="Newaddbook.jsp">Add books</a><br><br>
<!-- <a href="library.jsp">Library</a><br><br>
<a href="newfindbut.jsp">new find</a><br><br> -->
  
  <a href="emp.jsp">Employee Details</a><br><br>
  <a href="borrowbook.jsp">Borrow Books</a><br><br>
  <a href="returnbook.jsp">Return books</a><br><br>
 
<!--   <a href="./Newfindall.do">booklist</a><br><br> -->   
 <!--  <a href="bookstatus.jsp">Book Status</a><br><br> -->
<!--   <a href="finddatelist.jsp">Book Status</a><br><br> -->
  <html:form  action="datelist"  method="post"  >
<pre>
<html:submit property="datelist">  <bean:message key="datelist"/></html:submit>
</pre>
</html:form>

<a href="logout.jsp">Logout</a><br><br>
</body>
</html>