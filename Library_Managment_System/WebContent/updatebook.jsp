<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%-- <<html:errors/> --%>
<html>
<h1>Update Books </h1>
<html:form  action="updat"  >
Enter ID to update the book
<pre>

 Book Id        <html:text property="bookid" />  <html:errors property="bookid" />  <br>

<html:submit>   <bean:message key="updatebook"/></html:submit>
<h3><a href="home.jsp"><--Back </a></h3>
</pre>
</html:form>
</html>