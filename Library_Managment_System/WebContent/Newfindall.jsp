<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<style>

table, th, td {
  border:1px solid black;
  border-style:solid;
    border-color: #96D4D4;
  border-collapse: collapse;
}
tr:nth-child(even) {
  background-color: #D6EEEE;
}

   h1 {
     border: 5px solid black; 
      text-align: center; 
    width: 40%;
    font-size: 30pt;
}
</style>

<body style="background-color:#fffbf0;">
<center>

<h1>BOOK LIST</h1>
<table style="width: 40%;">
<%-- <colgroup>
  <col span="4" style="background-color: #D6EEEE">
</colgroup> --%>
<tr>
	<th>BOOK ID</th>
	<th>BOOK NAME</th>
	<th>AUTHOR</th>
	<th>BOOK COST</th>
</tr>
<c:forEach items="${reslist}" var="list">
<tr> 
	<td ><html:link action="/returnupdatedelete?Bookid=${list.bookid}"><c:out value="${list.bookid}" /></html:link></td> 
	<%-- <td><c:out value="${list.bookid }" /></td> --%>
	<td><c:out value="${list.bookname }" /></td>
	<td><c:out value="${list.author }" /></td>
	<td><c:out value="${list.bookcost }" /></td>
</tr>
</c:forEach>
</table><br><br>
<%-- <html:link action="/pagination?page=1">1</html:link>
<html:link action="/pagination?page=2">2</html:link>  --%> 


<span style="color:blue">Click on id to update or delete</span>
<h3> <a href="Newaddbook.jsp"><--Back </a></h3>
<span style="color:blue">For Go to login page Click Here!--></span><a href="home.jsp"><h3>HOME</h3></a>
</center>
</body>

</html>