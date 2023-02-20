<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String msg=(String)request.getAttribute("msg"); 
%>
<style>
 div {
        margin-bottom: 5px;
      }
      label {
        display: inline-block;
        width: 150px;
        text-align: right;
      }
      
      h1 {
     border: 5px solid black; 
      text-align: center; 
     width: 50%;
     font-size: 30pt;
}</style>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<html>
<h1>Borrow Books</h1>
 <% java.util.Date date = new Date();  
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	 String strDate = sdf.format(date);
	 System.out.println("strDate "+strDate); %>
<html:form  action="borrowbook"  onsubmit="return validatorborrow(this);"><html:javascript formName="borrow"  />
<pre> 
 <h3 style="color:red"><%if(msg!= null){out.print(msg);}%></h3> 
 <div>
 <label>bookid:</label><i class='fas fa-pen-square'></i> <html:text property="bookid" />  <html:errors property="bookid" /><br><br>
 <label>empid:</label><i class="fa fa-address-card" ></i> <html:text property="userid" />  <html:errors property="userid" /><br><br> 
 <label>issuedate:</label><i class='fas fa-calendar-check'></i> <html:text property="issuedate"  value="<%= strDate %>"/>  <html:errors property="issuedate" /><br>


             <html:submit property="borrowbook">   <bean:message key="borrowbook"/></html:submit>
</pre>
</div>
</html:form>
            <h3><a href="home.jsp"><--Back </a></h3>
</html>