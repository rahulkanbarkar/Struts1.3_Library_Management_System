<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<h1>Delete Employees</h1>
<%-- <html:errors /> --%>
<html:form  action="empdelete"  method="post"  >
<pre>
empid <html:text property="userid" />  <html:errors property="userid" /> Invalid empid , please chech the empid and try again


<html:submit property="empdelete">   <bean:message key="empdelete"/></html:submit>

</pre>
<h3><a href="home.jsp"><--Back </a></h3>
</html:form>

</html>