<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<h1>BOOK STATUS</h1>
<%-- <html:errors /> --%>

<html>
<h1>Add Employees</h1>
<%-- <html:errors /> --%>
<html:form  action="findall"/>


<html:submit property="findall">   <bean:message key="findall"/></html:submit>

<pre>
<h3><a href="home.jsp"><--Back </a></h3>
</html>
