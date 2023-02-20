<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<h1>Find Books</h1>
<%-- <html:errors /> --%>
<html:form  action="findbook"  method="post"  >
<pre>
<%-- <bean:message key="bookid"/>    <html:text property="bookid"/> --%>
<bean:message key="bookname"/>    <html:text property="bookname"/>
<html:submit property="findbook">   <bean:message key="findbook"/></html:submit>
<h3><a href="home.jsp"><--Back </a></h3>
</pre>
</html:form>
</html>