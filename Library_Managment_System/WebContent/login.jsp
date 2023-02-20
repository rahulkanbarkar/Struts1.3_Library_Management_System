<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 <link rel="stylesheet" href="logins.css">
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
  
      div {
        margin-bottom: 10px;
      }
      label {
        display: inline-block;
        width: 150px;
        text-align: right;
      }
      h1 {
 
    border: 5px solid black; 
      text-align: center; 
    /* height: 40px; */ 
    width: 30%;
/*    align="justify" */
    font-size: 30pt;
}

</style>

<script src="https://kit.fontawesome.com/d555bfbfa5.js" crossorigin="anonymous"></script>
 <title>Employee Database System</title>
 </head>
 <body style="background-color:pink;background-repeat: no-repeat;  background-attachment: fixed;
  background-size:100%;">

<h1>Login Form</h1>

<html:form action="login">

<h3>
<div>
<label>userid*:<i class="fa fa-address-card" ></i> </label>   <html:text property="id" />       <html:errors property="id" /><br><br>

<label>Password*:<i class='fas fa-user-lock'></i> </label>   <html:text property="password" />   <html:errors property="password" /><br> 


<% String err=(String)request.getAttribute("invaliddata"); 
%>
<h3 style="color:red">
<%if(err!= null){
out.print(err);
}%>
</h3>
<label><html:submit>Login</html:submit><br><br>
<html:reset />
</html:form>

<h4><span style="color:blue">If you are a New User! click here </span></h4>		
<h3> <a href="reg.jsp">Register </a></h3></label>
</div>
 	


 </body>
 </html>
 
