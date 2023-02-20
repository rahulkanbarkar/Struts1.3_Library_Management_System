<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String msg=(String)request.getAttribute("msg"); 
%>



<html>
<h1>Update Employees   </h1>
<%-- <html:errors /> --%>
<html:form  action="empupdate"  method="post"  >
<pre>

empid <html:text property="userid" />  <html:errors property="userid" /> Invalid id please enter valid id <h3 style="color:red"><%if(msg!= null){out.print(msg);}%></h3> 
empName <html:text property="username" />  <html:errors property="username" /><br><br>
<html:submit property="empupdate">   <bean:message key="empupdate"/></html:submit>
</pre>
</html:form>
<h3><a href="home.jsp"><--Back </a></h3>
</html>