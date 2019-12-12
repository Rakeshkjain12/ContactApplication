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
<s:url var="url_jquery" value="/static/js/jquery-3.4.1.min.js"/>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<script src="${url_jquery}" type="text/javascript"></script>
  <%--   <script>
    $(function(){
    	$("#btnSubmit").click(function(){
    		  var pass=$("#password").val();
    		  var confirmpass=$("#confirmPassword").val();
    		  if(pass!=confirmpass){}
    		  alert("Password do not match");
    		  return false;
    	});
    	return true;
    });
    </script> --%>
    
    <script>
    $(document).ready(function(){
        $("#confirmPassword").keyup(function(){
             if ($("#password").val() != $("#confirmPassword").val()) {
                 $("#msg").html("Password do not match").css("color","red");
                 $(':submit').prop('disabled', true);
             }else{
                 $("#msg").html("Password matched").css("color","green");
                 $(':submit').prop('disabled', false);
            }
      });
});
</script> 
    
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
				<c:if test="${param.act eq 'snt'}">
				     <p class="success">OTP Send on email Successfully....Valid Only for 5 Min.</p>
				  </c:if>
				<c:if test="${param.act eq 'suc'}">
				     <p class="success">"Password Reset Successfully Please login to continue..."</p>
				  </c:if>
				  	 <c:if test="${param.act eq 'fil'}">
				     <p class="success">"Sorry Try Again After Some Time"</p>
				  </c:if>
				<h3>Password Reset</h3>
			<s:url var="url_rePass" value="/genePassword"/>
				<form:form action="${url_rePass}" >
				  <table cellpadding="8"> 
				  
				  
				  
		           <tr>
				      <td>Email :</td>
				<td><input type="email" name="email"  size="40"/>
				</td>
				
				    </tr>
				    <tr>
				      <td>Insert One Time Password (OTP)</td>
				      <td><input type="text" name="otp" size="10">
				      </td>
				    </tr>
				    <tr>
				      <td>Password :</td>
				<td><input type="password" name="password" id="password" size="40"/>
				</td>
				
				    </tr><tr>
				      <td>Confirm Password</td>
				      <td><input type="password" name="cpassword" id="confirmPassword" size="40">
				      <div id="msg"></div>
				      </td>
				      
				    </tr>
				    <tr>
				      <td colspan="2">
				      <button  disabled="disabled" >RESET PASSWORD</button><br>
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