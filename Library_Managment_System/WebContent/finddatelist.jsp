<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<h1>BOOK STATUS</h1>
<%-- <html:errors /> --%>
<html:form  action="datelist"  method="post"  >
<pre>
<%-- <bean:message key="bookid"/>    <html:text property="bookid"/> --%>
<html:submit property="datelist">   <bean:message key="datelist"/></html:submit>
</pre>
</html:form>
<h3><a href="home.jsp"><--Back </a></h3>
</html>
