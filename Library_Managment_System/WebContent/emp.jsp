<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<style>
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 8px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
 a:hover, a:active {
  background-color: red;
} 
</style>
</style>
</head>
<h1>Employees Section</h1>
<html:errors />
<html:form  action="emplist"  method="post"  >
<pre>
<html:submit property="emplist">   <bean:message key="emplist"/></html:submit>
</pre>
</html:form>
<a href="empdetails.jsp">Add employee</a><br><br>
<a href="empupdate.jsp">update employe</a><br><br>
<a href="empdelete.jsp">Delete employe</a><br><br>
<a href="empfind.jsp">Search employe</a><br><br>
<a href="home.jsp"><--Back </a></h3>
<!-- <a href="./emplist.do">Employee List</a><br><br>  -->

</html>