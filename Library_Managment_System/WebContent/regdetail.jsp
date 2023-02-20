<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>

<html>
<h3>Your Details Submitted Successfully :) </h3>

<%
		List list = (List) request.getAttribute("list");
	%>
		<%
	if(list != null ){
		out.print("ID: "+list.get(0)+"<br>");  		/* out.println(list.get(0)+"\n");  */
		out.print("FirstName: "+list.get(1)+"<br>");	 	/* out.println(list.get(1)+"\n"); */
		out.print("LastName: "+list.get(2)+"<br>");	 	/* out.println(list.get(2)+"\n"); */
		out.print("DOB: "+list.get(3)+"<br>");	 			/* out.println(list.get(3)+"\n"); */
		out.print("Age: "+list.get(4)+"<br>");	 			/* out.println(list.get(4)+"\n"); */
		out.print("City: "+list.get(5)+"<br>");	 		/* out.println(list.get(5)+"\n"); */
			  				
	}
	%>
	<h3>
	<a href="login.jsp">login</a>
	</h3>


</html>

