<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
	<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page isErrorPage="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Contact App - User Dashboard</title>
<s:url var="url_css" value="/static/css/style.css"/>
<link href="${url_css}"  rel="stylesheet" type="text/css">
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>

<body background="${url_bg}">






	<table border="1" width="90%" align="center">
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
				<h1>User Dashboard</h1>
				<h4>User Profile</h4>
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
				<s:url var="url_editUser" value="/user/editUser"></s:url>
				<form:form action="${url_editUser}" modelAttribute="command">
				<button name="${u.userId}" >Edit</button></form:form>
					<s:url var="url_editDelete" value="/user/deleteUser"></s:url>
				<form:form action="${url_editDelete}" modelAttribute="command">
				<button id="id_deleteUser">Delete</button></form:form>
			</td>
		</tr>
		<tr>
			<td height="75px">
				<!-- footer area -->
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>
	</table>
</body>
</html>