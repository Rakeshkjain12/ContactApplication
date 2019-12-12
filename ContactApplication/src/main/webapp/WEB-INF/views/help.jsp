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
<s:url var="url_css" value="static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>

<s:url var="url_bg" value="static/images/bg.jpg"/>

<body background="${url_bg}">
	<table width="90%" align="center">
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
				<h1>Help</h1>
				<div align="left">If Any Case of difficulty Contact Us:<br></div>
				
				<h4 align="left">Rakesh Jain</h4>
				<div align="left" onmousemove="     "> <a href="#">Email:jainrakeshindia@gmail.com</a><br>
				 Mob:+91 7354717670, +91 9713525213</div>
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