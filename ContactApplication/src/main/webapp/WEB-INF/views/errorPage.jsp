<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<s:url var="url_bg" value="static/images/"/>
<body background="${url_bg}">
 <div align="center">
  <h1 style="color: red"><blink> ${errorTitle}</blink></h1><br>
 <h3 style="color: red">${errorDescription}</h3>

 </div>

</body>
</html>