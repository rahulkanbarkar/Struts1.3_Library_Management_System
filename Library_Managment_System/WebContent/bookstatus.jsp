	


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body style="background-color:#fffbf0;">
<center>
<table border="1">
<tr>

	<th>BOOK ID</th>
	<th>BOOK Name</th>
	<th>BORROW ID</th>
	<th>USERID</th>
	<th>USER NAME</th>
	<th>ISSUE DATE</th>
	<th>RETURN DATE</th>
<!-- 	<th>USER ID</th> -->

</tr>	
<c:forEach items="${reslist }" var="list">
<tr>
	<td><c:out value="${list.bookid   }" /></td>
	<td><c:out value="${list.bookname }" /></td>
	<td><c:out value="${list.borrowid  }" /></td>
	<td><c:out value="${list.userid  }" /></td> 
	<td><c:out value="${list.username }" /></td> 
	<td><c:out value="${list.issuedate  }" /></td> 
	<td><c:out value="${list.returndate }" /></td> 
	<%-- <td><c:out value="${list.userid}" /></td> --%>
</tr>
</c:forEach>
</table>
<h3> 
<a href="home.jsp"><--Back </a></h3>

</center>
</body>
</html>