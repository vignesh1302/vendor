<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grizzly Store</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
 
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .logo
{
	text-align:center;
}

.form #textbox input
{

	border-radius:50px;
	height:30px;
	width:250px;
	display:block;
	margin:0 auto;
	background-color:#F1EBEB;
	padding-left:20px;
	padding-left:20px;
	font-weight:bold;
	color:grey;

}

.form #login input
{
	text-align:center;
	border-radius:50px;
	display:block;
	margin:0 auto;
	margin-top:20px;
	background-color:#D1C6C6;
	height:40px;
	width:100px;
}
  </style>
</head>
<body>

<% 
if(request.getAttribute("error")!=null)
{
	String error= request.getAttribute("error").toString();
	out.write(error);
}
%>
<div class="logo"><img src="/grizzle-store/images/image2.JPG"></div>

<div class="form" >
<form action="/grizzle-store/app/LoginController" method = "post" >
<div id="textbox"><input type="text" class='btn' name="username" placeholder="Username" style="outline:none;"></div> 
<div id="textbox"><input type="password" class='btn' name="password" placeholder="Password" style="margin-top:10px;outline:none;"></div>
<div id="login"><input type="submit" class='btn' name="login" value="login" formmethod="POST" style="text-shadow: 1px 1px grey;outline: none;"></div>
 </form>


</div>
</body>
</html>