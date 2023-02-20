<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<body style="background-color:#fffbf0;">
<center>
<h1>BOOK LIST</h1>
<table border="1">
<tr>
	<th>BOOK ID</th>
	<th>BOOK Name</th>
	<th>AUTHOR</th>
	<th>BOOK COST</th>
	<th>UPDATE BOOK</th>
	<th>DELETE BOOK</th>
	
<!-- 	<th>USER ID</th> -->
</tr>	
<c:forEach items="${reslist }" var="list">
<tr>

    <td ><html:link action="/returnupdatedelete?bookid=${list.bookid}"><c:out value="${list.bookid}" /></html:link></td> 
	<%-- <td><c:out value="${list.bookid   }" /></td> --%>
	<td><c:out value="${list.bookname }" /></td>
	<td><c:out value="${list.author  }" /></td>
	<td><c:out value="${list.bookcost  }" /></td>
   <td><a href="updatebook.jsp">edit</a></td>
 
<%--  <td><a action="updatebook?bookid=<c:out value='${list.bookid}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="delete?id=<c:out value='${book.id}' />">Delete</a>                        </td>
     
	 <td><html:link action="updatebook/${list.bookid}" >EdiT</html:link>  </td> 
	 --%>
	
	<td><a href="deletebook.jsp">Delete</a></td>
	
	
		
	<%-- <td><c:out value="${list.userid}" /></td> --%>
</tr>
</c:forEach>
</table>
<h3> 
<!-- <html:submit property="submit">exportxl</html:submit> -->
<a href="home.jsp"><--Back </a></h3>
<a href="library.jsp"><--Library </a></h3>
<%-- <td><c:out value="5" /></td>  --%>
<html:form  action="savebook" >
 <html:submit property="savebook">exportxl</html:submit><br>	
</pre>
</html:form>
</center>
</body>
</html>




