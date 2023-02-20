<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<h1>Search Employees</h1>
<html:errors />
<html:form  action="empfind"  method="post"  >
<pre>
<%-- <bean:message key="userid"/>          <html:text property="userid"/> --%>
<bean:message key="username"/>        <html:text  property="username"/>
<html:submit property="empfind">   <bean:message key="empfind"/></html:submit>
</pre>
</html:form>
<h3><a href="home.jsp"><--Back </a></h3>
</html>