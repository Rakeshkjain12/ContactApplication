<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <s:url var="url_jquery" value="/static/js/jquery-3.4.1.min.js"/>
    <script src="${url_jquery}" type="text/javascript"/>
    <script>
    $(document).ready(function(){
  	//  alert('JQuery is working');
  	
  $("#id_get_time").click(function(){
	  
	 // alert("button clicked");
  		 $.ajax({
  			url: 'get_time',
  			data:{},
  			success:function(data){
  				$("#id_time").html(data);
  			}
  		});  
  	});
    });
  
    </script>
<title>Insert title here</title>
</head>
<body>
<p>Test Page</p>

<button id="id_get_time">Click Me</button>
<p id="id_time"></p>
</body>
</html>