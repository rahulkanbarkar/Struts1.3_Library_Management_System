<%@page import="java.util.List"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<% String msg=(String)request.getAttribute("msg"); %>

<%-- <% String msg = (String) request.getAttribute("msg"); %>
	<%
		String err = (String) request.getAttribute("doberror");
	%> --%>
	
<html>
<head>
<title>Employee Regestration page</title>

<style>
.column {
	float: left;
	width: 50%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
   }
    div {
        margin-bottom: 10px;
      }
      label {
        display: inline-block;
        width: 150px;
        text-align: right;
      }
</style>
<script src="https://kit.fontawesome.com/d555bfbfa5.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<%
		String err = (String) request.getAttribute("doberror");
	
	%>

<%-- <%
		List list = (List) request.getAttribute("list");

	%> --%>
	
	<!-- <div class="row">
		<div class="column"> -->
			<pre>
<h1 style="border: 2px solid black; height: 50px; width: 500px; font-size: 20pt;"> Employee Registration Form</h1>
<html:form action="/adminreg.do" styleId="details">
      <div>
<label>Admin Id*:<i class="fa fa-address-card" ></i></label> <html:text property="id" styleId="adminid" />  <html:errors property="id" /><h3 style="color: red">	<%	if (msg != null) { out.print(msg) ;}%>	</h3>
<label>First Name*:<i class="fa fa-user-circle-o"></i></label> <html:text property="firstname" styleId="firstname" /> <html:errors property="firstname" /><br><br>				 
<label>Last Name*:<i class="fa fa-user-circle-o"></i></label> <html:text property="lastname" styleId="lastname" /> <html:errors property="lastname" /><br> <br>  
<label>DOB*:<i class='far fa-calendar-alt'></i></label> <html:text property="dob" styleId="dob" /> <html:errors	property="dob" /> format(yyyy/MM/dd) <%if (err != null) {out.print(err); } %><br><br>  
<label>Age*:</label><html:text property="age" styleId="age" /> <html:errors property="age" /> <br><br>
<label>city:<i class='far fa-building'></i></label> <html:select property="city" style="width:152px" styleId="city"><br><br>
<html:option value="null">City</html:option>
<html:option value="Banglore">Banglore</html:option>
<html:option value="Mumbai">Mumbai</html:option>
<html:option value="Hydrabad">Hydrabad</html:option>
<html:option value="Goa">Goa</html:option>
<html:option value="Delhi">Delhi</html:option>
<html:option value="Kolkatta">Kolkatta</html:option>
<html:option value="Kashmir">Kashmir</html:option>
<html:option value="Sikkim">Sikkim</html:option>
<html:option value="Chennai">Chennai</html:option>
</html:select>
 
<label>Password*:<i class='fas fa-user-lock'></i> </label><html:text property="password" /> <html:errors property="password" /><br><br>
					</div>
			
<label> <html:submit property="submit">save</html:submit> </label>
 </html:form>
</pre>
		</div>
	<%-- 	<div class="column">
		<!-- <h3>Your Details Submitted Successfully :) </h3> -->
		<%
	if(list != null ){
		out.print("ID: ");  			out.println(list.get(0)+"\n"+System.lineSeparator()); 
		out.print("FirstName: ");	 	out.println(list.get(1)+"\n"+System.lineSeparator());
		out.print("LastName: ");	 	out.println(list.get(2)+"\n"+System.lineSeparator());
		out.print("DOB: ");	 			out.println(list.get(3)+"\n"+System.lineSeparator());
		out.print("Age: ");	 			out.println(list.get(4)+"\n"+System.lineSeparator());
		out.print("City: ");	 		out.println(list.get(5)+"\n"+System.lineSeparator());
			  				
	}
	%>
		</div> --%>
	</div>
</body>
<a href="login.jsp">
	<h1>Login Page</h1>
</a>
</html>