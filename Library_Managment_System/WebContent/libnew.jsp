<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String msg=(String)request.getAttribute("msg"); 
%>


<html>
<h1>Add Books</h1>
<%-- <html:errors /> --%>
<html:form  action="savebook" >
 
<pre>
 bookid       : <html:text property="bookid" />  <html:errors property="bookid" /> <mark><%if(msg!= null){out.print(msg);}%></mark> <br><br>
 bookname     :  <html:text property="bookname" />  <html:errors property="bookname" /><br><br> 
 author        :  <html:text property="author" />  <html:errors property="author" /><br><br> 
 Book Cost     :<html:text property="bookcost" />  <html:errors property="bookcost" /> <br>
<html:submit property="submit">   <bean:message key="submit"/></html:submit>
 <html:submit property="submit">exportxl</html:submit><br>	
<h3><a href="library.jsp">Library </a></h3>
<h3><a href="home.jsp">Home  </a></h3>
</pre>
</html:form>
</html>

