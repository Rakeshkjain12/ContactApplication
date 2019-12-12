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
<s:url var="url_jquery" value="/static/js/jquery-3.4.1.min.js"/>
    <script src="${url_jquery}" type="text/javascript"></script>
    <script>
    $(document).ready(function(){
      	
      $("#id_check_avail").click(function(){
    	  
      		 $.ajax({
      			url: 'check_user_avail',
      			data:{loginName:$("#id_loginName").val()},
      			success:function(data){
      				$("#id_res_div").html(data);
      			}
      		});  
      	});
    });
    </script>
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
				<h3>User Registration</h3>
				<s:url var="url_reg" value="/register"/>
				<form:form action="${url_reg}" modelAttribute="command">
				  <table border="0" align="center"> 
				  
				  <c:if test="${err!=null}">
				     <p class="error">${err}</p>
				  </c:if>
				   
				
				    <tr>
				      <td>Name</td>
				      <td><form:input path="user.name"/></td>
				    </tr>
				     <tr>
				      <td>Phone</td>
				      <td><form:input path="user.phone"/></td>
				    </tr>
				     <tr>
				      <td>Email</td>
				      <td><form:input path="user.email"/></td>
				    </tr>
				     <tr>
				      <td>Address</td>
				      <td><form:textarea path="user.address"/></td>
				    </tr>
				    <tr>
				      <td>LoginName</td>
				      <td><form:input id="id_loginName" path="user.loginName"/>
				      <button id="id_check_avail" type="button">Check Availability</button>
				      <div id="id_res_div" class="error"></div>
				      </td>
				    </tr>
				    <tr>
				      <td>Password</td>
				      <td><form:password path="user.password"/></td>
				    </tr>
				    <tr>
				      <td colspan="2" align="right">
				      <button>Submit</button><br>
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