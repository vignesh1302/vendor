<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
if(request.getAttribute("err")!=null)
{
	String error=request.getAttribute("err").toString();
	out.write(error);
}
%>
<jsp:forward page="../jsp/login1.jsp"></jsp:forward>
</body>
</html>