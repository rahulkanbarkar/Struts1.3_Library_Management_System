<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<pre>

<%-- <%
List l=(List)request.getAttribute("list");

%> --%>

<table border="1">
<tr><th>BORROW ID  <th>BOOK ID</th>   <th> USER ID </th>  <th> BORROW DATE </th> <th> RETURN DATE </th> <!-- <th>USER ID</th> --> </tr>
<c:forEach items="${list }" var="list">
  <tr>
 	<td><c:out value="${list.borrowid   }" /></td>
	<td><c:out value="${list.bookid }" /></td>
	<td><c:out value="${list.userid  }" /></td>
	<td><c:out value="${list.date  }" /></td> 
	<td><c:out value="${list.returndate  }" /></td> 
	<%-- <td><c:out value="${list.userid}" /></td> --%>
	
	</tr>
 </c:forEach>
</table>
</pre>
