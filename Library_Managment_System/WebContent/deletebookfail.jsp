<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String msg=(String)request.getAttribute("msg"); 
%>

<html>
<h1>Delete Books</h1>
<%-- <html:errors /> --%>
<html:form  action="deletebook"  method="post"  > 
<pre>
 bookid        <html:text property="bookid" />  <html:errors property="bookid" />  invalid book id, please check the book id and try again<br><h3 style="color:red"><%-- <%if(msg!= null){out.print(msg);}%></h3> --%> 
<html:submit property="deletebook">   <bean:message key="deletebook"/></html:submit>
<h3><a href="home.jsp"><--Back </a></h3>
</pre>
</html:form>
</html>