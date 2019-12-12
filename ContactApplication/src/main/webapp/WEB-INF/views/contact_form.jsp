<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
	<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact App - Login Form</title>
<s:url var="url_css" value="/static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>

<s:url var="url_bg" value="/static/images/bg.jpg"/>

<body background="${url_bg}">
	<table border="1" width="100%" >
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
				<h3>Add Contact</h3>
				<s:url var="url_csave" value="/user/save_contact"/>
				<form:form action="${url_csave}" modelAttribute="command">
				  <table  width="90%"> 
				  
				  <c:if test="${err!=null}">
				     <p class="error">${err}</p>
				  </c:if>
				
				    <tr>
				      <td>Name</td>
				      <td><form:input path="name"  size="50" /></td>
				    </tr>
				     <tr>
				      <td>Phone</td>
				      <td><form:input path="phone" size="50" /></td>
				    </tr>
				     <tr>
				      <td>Email</td>
				      <td><form:input path="email" size="50" /></td>
				    </tr>
				     <tr>
				      <td>Address</td>
				      <td><form:textarea path="address" /></td>
				    </tr>
				     <tr>
				      <td>Remark</td>
				      <td><form:textarea path="remark" /></td>
				    </tr>
				    <tr>
				      <td colspan="2" align="right">
				      <button >Save</button><br>
				      </td>
				    </tr>
				  </table>
				</form:form>
				
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