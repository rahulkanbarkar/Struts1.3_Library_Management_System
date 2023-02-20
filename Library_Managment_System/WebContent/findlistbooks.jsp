<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<pre>

<%-- <%
List l=(List)request.getAttribute("list");

%> --%>
<h2>Search Results</h2>
<table border="1">
<tr><th>BOOK ID  <th>BOOK NAME</th>   <th>  AUTHOR NAME </th>  <th> BOOKCOST </th>  <!-- <th>USER ID</th> --> </tr>
<c:forEach items="${list }" var="list">
  <tr>
 	<td><c:out value="${list.bookid   }" /></td>
	<td><c:out value="${list.bookname }" /></td>
	<td><c:out value="${list.author  }" /></td>
	<td><c:out value="${list.bookcost  }" /></td> 

	</tr>
 </c:forEach>
</table>
<a href="home.jsp"><h3>home</h3></a>
</pre>
