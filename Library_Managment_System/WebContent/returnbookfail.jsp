<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String err=(String)request.getAttribute("doberror"); %>
<html>
<h1>Return Books</h1>
 <% java.util.Date date = new Date();  
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	 String strDate = sdf.format(date);
	 System.out.println("strDate "+strDate); %>
<%-- <html:errors />  --%>
<html:form  action="returnbook"  method="post"> <%-- onsubmit="return validatorborrow(this);">
<html:javascript formName="borrow"  /> --%>
<pre>

bookid:    <html:text property="bookid" />  <html:errors property="bookid" />enter valid id ,please enter valid bookid and try again<%if(err!= null){out.print(err);}%><br><br>

returndate:<html:text property="returndate" value="<%= strDate %>" />   <html:errors property="returndate" /><br> 
<%-- <bean:message key="bookid"/>          <html:text property="bookid"/>
<bean:message key="returndate"/>        <html:text  property="returndate"/> --%>

<html:submit property="returnbook">   <bean:message key="returnbook"/></html:submit>
</pre>
</html:form>
<h3><a href="home.jsp"><--Back </a></h3>
</html>