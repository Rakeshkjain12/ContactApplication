<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<div>
<s:url var="url_logout" value="/logout"/>
<s:url var="url_reg" value="/reg_form"/>
<s:url var="url_index" value="/index"/>
<s:url var="url_home" value="/home"/>
<s:url var="url_help" value="/help"/>
<c:if test="${sessionScope.userId==null }">
  <!--User is not yet Logged in: Guest Menu -->
<a href="${url_home}">Home</a> | <a href="${url_index}">Login</a> | <a href="${url_reg}">Register</a> | <a href="#">About</a> | <a href="${url_help}">Help</a> 

</c:if>

<c:if test="${sessionScope.userId!= null && sessionScope.role==1 }">
  <!--Admin user is Logged in: Admin menu -->
  <s:url var="url_dashboard" value="/admin/dashboard"/>
<a href="${url_dashbboard}">Home</a> | <a href="<s:url value="/admin/getuserList"/>">User List</a> | <a href="${url_logout}">Logout</a> 

</c:if>

<c:if test="${sessionScope.userId!= null && sessionScope.role==2 }">

  <!-- General User is Logged in: User Menu  -->
        <s:url var="url_uhome" value="/user/dashboard"/>
        <s:url var="url_cform" value="/user/contact_form"/>
        <s:url var="url_clist" value="/user/clist"/>
          
<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${url_logout}">Logout</a> 

</c:if>
<hr>
</div>