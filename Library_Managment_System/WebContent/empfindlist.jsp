<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<pre>

<%-- <%
List l=(List)request.getAttribute("list");

%> --%>

<table border="1">
<tr><th>USER ID  <th>USER NAME</th> </tr>
<c:forEach items="${list }" var="list">
  <tr>
 	<td><c:out value="${list.userid  }" /></td>
	<td><c:out value="${list.username }" /></td>
	
	</tr>
	
 </c:forEach>
</table>
<h3><a href="home.jsp"><--Back </a></h3>
</pre>
