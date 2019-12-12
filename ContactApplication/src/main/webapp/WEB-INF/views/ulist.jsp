<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User - Contact App</title>
 <s:url var="url_jquery" value="/static/js/jquery-3.4.1.min.js" />
<script src="${url_jquery}" type="text/javascript" ></script> 
<s:url var="url_css" value="/static/css/style.css" />
<link href="${url_css}" rel="stylesheet" type="text/css">
<script>
  function changeStatus(uid, lstatus){
	  //alert(userId+" , "+loginStatus);
	  $.ajax({
		  url:'change_status',
		  data:{userId:uid, loginStatus:lstatus},
		  success:function(data){
			  alert(data);
		  }
		  
	  });
  }

</script>
</head>

<s:url var="url_bg" value="/static/images/bg.jpg" />

<body background="${url_bg}">
	<table border="1" width="90%" align="center">
		<tr>
			<td height="100px">
				<!--  Header Area --> <jsp:include page="include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- menu Area --> <jsp:include page="include/menu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="400px" valign="top">
				<!--contant area  -->
				<h3>All User</h3> <c:if test="${param.act eq 'del'}">
					<p class="success">User Successfully Deleted</p>
				</c:if> <c:if test="${param.act eq 'ed'}">
					<p class="success">User Successfully Updated</p>
				</c:if> <%-- <p align="left"> 
				    <form action="<s:url value="/user/contact_search"/>"  >
				      <input type="text" name="freeText" placeholder="Enter text to search" >
				      <button>Find</button>
				  </form>
				    </p> --%> <br> <%-- 	<form action="<s:url value="/user/bulk_cdelete"/>">
				  <button>Delete Selected Record</button>
				  </br></br> --%>
				<table border="1" cellpadding="6" width=100%>
					<tr>
						<th>SELECT</th>
						<th>SR</th>
						<th>UID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>LOGIN NAME</th>
						<th>LOGIN STATUS</th>
					
					</tr>
					<c:if test="${empty userList}">
						<tr>
							<td colspan="8" class="error" align="center">No Record
								Avaliable</td>
						</tr>
					</c:if>


					<c:forEach var="u" items="${userList}" varStatus="st">
						<tr>
							<td align="center"><input type="checkbox" name="uid"
								value="${u.userId}"></td>
							<td>${st.count}</td>
							<td>${u.userId}</td>
							<td>${u.name}</td>
							<td>${u.phone}</td>
							<td>${u.email}</td>
							<td>${u.address }</td>
							<td>${u.loginName }</td>
							<td><select id="id_${u.userId}" onchange="changeStatus(${u.userId},$(this).val( ))">
									<option value="1">Active</option>
									<option value="2">Block</option>

							</select>
							 <script>
                               $('#id_${u.userId}').val(${u.loginStatus});
                               </script>
							</td>
                              
							<%-- <s:url var="url_del" value="">
						  <s:param name="uid" value="#"></s:param>
						</s:url>
						
						<s:url var="" value="/user/edit_contact">
						  <s:param name="cid" value="${c.contactId}"></s:param>
						</s:url> --%>
						</tr>
					</c:forEach>

				</table> <%-- </form> --%>
			</td>
		</tr>
		<tr>
			<td height="75px">
				<!-- footer area --> <jsp:include page="include/footer.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>