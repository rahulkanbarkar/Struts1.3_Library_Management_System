<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<body style="background-color:#fffbf0;">
<html:form action="/savebook">
<center>
<html:errors/>
<h1>UPDATE OR DELETE BOOK</h1>
<table border="2">
<tr>
	<th>BOOKID</th>
	<th>BOOKNAME</th>
	<th>AUTHOR</th>
	<th>BOOKCOST</th>


</tr>
<c:forEach items="${updatelist}" var="list">
<tr>
	<td><html:link action="/returnupdatedelete"> <c:out value="${list.bookid }" /></html:link></td>
	<%-- <td><c:out value="${list.name }" /></td>
	<td><c:out value="${list.email }" /></td>
	<td><c:out value="${list.gender }" /></td>
	<td><c:out value="${list.username }" /></td>
	<td><c:out value="${list.password }" /></td> --%>
	<td ><input type="text" name="bookname"  value='<c:out value="${list.bookname }"/>' /></td>
	<td><input type="text" name="author"  value='<c:out value="${list.author }"/>' /></td>
	<td><input type="text" name="bookcost"  value='<c:out value="${list.bookcost}"/>' /></td>
	
	<td><input name="bookid" type="hidden" value='<c:out value="${list.bookid }"/>' /></td>
	<td><input name="bookname" type="hidden" value='<c:out value="${list.bookname }"/>' /></td>
	<td><input name="author" type="hidden" value='<c:out value="${list.author }"/>' /></td>
	<td><input name="bookcost" type="hidden" value='<c:out value="${list.bookcost}"/>' /></td>
</tr>
</c:forEach>
</table><br><br>
<center>
 <html:submit property="submit">update</html:submit><br><br>
        <html:submit property="submit">delete</html:submit></center><br>
  
  <html:submit property="submit">findAll</html:submit>
<a href="home.jsp"><h3><--Home</h3></a>
</html:form>
</body>
       
</html>