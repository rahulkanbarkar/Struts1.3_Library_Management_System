<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String msg=(String)request.getAttribute("msg"); 
%>
<% String err=(String)request.getAttribute("bookname"); %>

<html>
<h1>Update Books</h1>
<%-- <html:errors /> --%>
<html:form  action="saveupdatebook" onsubmit="return validatelibrary(this);"  >
<html:javascript formName="library" /> 
<pre>
<c:forEach items="${list }" var="list">
 bookid       : <html:text property="bookid" value="${list.bookid}"/>  <html:errors property="bookid" /> <mark><%if(msg!= null){out.print(msg);}%></mark> <br><br>
 bookname     :  <html:text property="bookname" value="${list.bookname}"/>  <html:errors property="bookname" />  <%if(err!= null){out.print(err);}%><br><br><br><br>
 author        :  <html:text property="author" value="${list.author }"/>  <html:errors property="author" /><br><br> 
 Book Cost     :<html:text property="bookcost" value="${list.bookcost }"/>  <html:errors property="bookcost" /> <br>
  </c:forEach>
<html:submit property="updatebook">   <bean:message key="updatebook"/></html:submit>
<h3><a href="library.jsp">Library </a></h3>
<h3><a href="home.jsp">Home  </a></h3>
</pre>
</html:form>
</html>

