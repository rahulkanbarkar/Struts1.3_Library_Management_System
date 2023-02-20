<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body style="background-color:#fffbf0;">
<center>
<table border="1">
<tr>
	<th>User Id</th>
	<th>First Name</th>
	<th>LAST NAME</th>
	<th>DOB</th>
	<th>AGE</th>
	<th>CITY</th>
	<th>PASSWORD</th>
<!-- 	<th>USER ID</th> -->

</tr>	
<c:forEach items="${reslist }" var="list">
<tr>
	<td><c:out value="${list.id   }" /></td>
	<td><c:out value="${list.firstname }" /></td>
	<td><c:out value="${list.lastname }" /></td>
	<td><c:out value="${list.dob }" /></td>
	<td><c:out value="${list.age  }" /></td> 
	<td><c:out value="${list.city }" /></td> 
	<td><c:out value="${list.password  }" /></td> 
</tr>
</c:forEach>
</table>
<h3> 
<a href="login.jsp"><--Back </a></h3>


</center>
</body>
</html>
