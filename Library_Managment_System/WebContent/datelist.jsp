<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<body style="background-color:#fffbf0;">

<center>
<h1>BOOK STATUS</h1>
<table border="1">
<tr>
	<th>BOOK ID</th>
	<th>USER ID</th>
	<th>ISSUE DATE</th>
	<th>RETURN DATE</th>
</tr>	
<c:forEach items="${list }" var="list">
<tr>
	<td><c:out value="${list.bookid   }" /></td>
	<td><c:out value="${list.userid }" /></td>
	<td><c:out value="${list.issuedate }" /></td>
	<td><c:out value="${list.returndate  }" /></td> 
</tr>
</c:forEach>
</table>
<h3> 
<a href="home.jsp"><--Back </a></h3>
<a href="library.jsp"><--Library </a></h3>

</center>
</body>
</html>
