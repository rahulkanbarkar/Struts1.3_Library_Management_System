<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<% String msg=(String)request.getAttribute("msg"); 
%>
<html>
<head>
<style>
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 5px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
 a:hover, a:active {
  background-color: green ;
} 

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
    /* height: 40px; */ 
    width: 50%;
/*    align="justify" */
    font-size: 30pt;
}
</style>

<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<head>
<title>Reg page</title>
</head>
<body style="background-color:#fffbf0;">
<!-- <center> -->
<pre>
<h1>Add BOOKS</h1>
<html:form action="savebook">
<div>
<label>BOOKID:</label><i class='fas fa-pen-square'></i> <html:text property="bookid" /> <html:errors property="bookid" /> <mark><%if(msg!= null){out.print(msg);}%></mark> 

<label>BOOKNAME:</label><i class="fa fa-book"></i> <html:text property="bookname" /> <html:errors property="bookname" />

<label>AUTHOR:</label><i class="fa fa-user-circle-o"></i> <html:text property="author" /><html:errors property="author" />

<label>BOOKCOST:</label><i class="fa fa-rupee"></i>  <html:text property="bookcost" /> <html:errors property="bookcost" />    
</div>  
</h4>
       <html:submit property="submit">save</html:submit><br>	
      <html:submit property="submit">findAll</html:submit><br>
     <html:submit property="submit">exportxl</html:submit> <br>
    <a href="fileUpload.jsp">Upload file</a><br> 
 <%--       <html:submit property="submit">importTextFile</html:submit> --%>
           </html:form>
</pre>
<a href="home.jsp"> <h2>home</h2></a>
</body>

</html>


         <%--  <html:file property="excelFile"></html:file>
           <html:submit>importFile</html:submit> --%>