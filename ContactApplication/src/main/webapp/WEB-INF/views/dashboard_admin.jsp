<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact App - Admin Dashboard</title>
<s:url var="url_css" value="/static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
<s:url var="url_jquery" value="/static/js/jquery-3.4.1.min.js"/>
    <script src="${url_jquery}" type="text/javascript"></script>
    <%-- <script>
   $(document).ready(function(){
      	
      $("#id_editUser").click(function(){
    	  $.ajax({
    		  url:"editUser",
    		  data:{${u.userId}},
    		  success: function(data){
    			 
    	  });
      		
    });
      $("#id_deleteUser").click(function(){
    	  
   		 alert("Delete Button Clicked");
 });
    }); 
    </script> --%>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>

<body background="${url_bg}">
<div align="center">
	<table  border="1" width="90%" >
		<tr>
			<td height="100px">
				<!--  Header Area -->
				<jsp:include page="include/header.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- menu Area -->
				<jsp:include page="include/menu.jsp"/>
			</td>
		</tr>
		
		<tr>
		
		
			<td height="400px" valign="top">
				<!--contant area  -->
				<h1>Admin Dashboard</h1>
				<h4>Admin Profile</h4>
				
				 <c:if test="${param.act eq 'ss'}">
				     <p class="error">Password not matched</p>
				  </c:if>
				   <c:if test="${param.act eq 'es'}">
				     <p class="success">Update Successfully</p>
				  </c:if>
				<table>
				
				  <tr>
				  <th>UserId</th>
				  <td>${u.userId}</td>
				  </tr>
				  
				   <tr>
				  <th>Name</th>
				  <td>${u.name}</td>
				  </tr>
				  
				   <tr>
				  <th>Phone</th>
				  <td>${u.phone}</td>
				  </tr>
				  
				   <tr>
				  <th>Email</th>
				  <td>${u.email}</td>
				  </tr>
				  
				   <tr>
				  <th>Address</th>
				  <td>${u.address}</td>
				  </tr>
				  
				   <tr>
				  <th>LoginName</th>
				  <td>${u.loginName}</td>
				  </tr>
				</table>
				<s:url var="url_editUser" value="/admin/editUser"></s:url>
				<form:form action="${url_editUser}" modelAttribute="command">
				<button name="${u.userId}" >Edit</button></form:form>
					<s:url var="url_editDelete" value="/admin/deleteUser"></s:url>
				
			</td>
		</tr>
		<tr>
			<td height="75px">
				<!-- footer area -->
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>
	</table></div>
</body>
</html>