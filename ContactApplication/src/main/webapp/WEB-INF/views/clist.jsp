<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Contact - Contact App</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="${url_css}" rel="stylesheet" type="text/css">
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
				<h3>All Contact</h3>
				<c:if test="${param.act eq 'sv'}">
				   <p class="success">Contact Save Successfully</p>
				</c:if>
				
				<c:if test="${param.act eq 'del'}">
				   <p class="success">Contact Successfully Deleted</p>
				</c:if>
				
				<c:if test="${param.act eq 'ed'}">
				   <p class="success">Contact Successfully Updated</p>
				</c:if>
				<c:if test="${param.act eq 'noSelect'}">
				   <p class="error">Please Select Record</p>
				</c:if>
				<p align="left"> 
				    <form action="<s:url value="/user/contact_search"/>"  >
				      <input type="text" name="freeText" placeholder="Enter text to search" >
				      <button>Find</button>
				  </form>
				    </p>
				 
				<br>
				
				<form action="<s:url value="/user/bulk_cdelete"/>">
				  <button>Delete Selected Record</button>
				  </br></br>
				<table border="1" cellpadding="6" width=100%>
					<tr>
					    <th>SELECT</th>
						<th>SR</th>
						<th>CID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>REMARK</th>
                        <th>ACTION</th>
					</tr>
                      <c:if test="${empty contactList}">
                      <tr>
                        <td colspan="8" class="error" align="center">No Record Avaliable</td>
                      </tr>
                      </c:if>
                      
                      
                      <c:forEach var="c" items="${contactList}" varStatus="st">
                      <tr>
                        <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td>
                        <td>${st.count}</td>
						<td>${c.contactId}</td>
						<td>${c.name}</td>
						<td>${c.phone}</td>
						<td>${c.email}</td>
						<td>${c.address }</td>
						<td>${c.remark }</td>
						
						<s:url var="url_del" value="/user/del_contact">
						  <s:param name="cid" value="${c.contactId}"></s:param>
						</s:url>
						
						<s:url var="url_edit_contact" value="/user/edit_contact">
						  <s:param name="cid" value="${c.contactId}"></s:param>
						</s:url>
                        <td><a href="${url_edit_contact}">EDIT</a> | <a href="${url_del}">DELETE</a></td>
                         </tr>
                      </c:forEach>
                   
				</table>

            </form>
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