<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navigation page : 4</title>
<meta name="viewport" content="width=device-width, initial-scale=1"> <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  #pic1  {
  border: 0.5px solid #ddd;
  border-radius: 4px;
  margin-top:10px;
  width: 150px;
}


#pic1:hover {
  box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5); }
#b1
{
	border-radius:50px;
	width:100px;

	background-color:#D1C6C6;
	color:black;
	font-weight: bold;
    
}
#t1
{
	border-radius:50px;
	color:black;
	width:250px;
	height:30px;
	position:relative;
	top:15px;
	left:60px;


}

#icon
{
	position:relative;
	top:16px;
	left:32px;
}

#icon2
{
	position:absolute;
	top:78px;
	left:388px;
}

#bell
{
	position:relative;
	top:18px;
}
#p1
{
	text-align:left;
}

#p2
{
	text-align:right;
}
.nav-pills #butt1 a
{
  background-color: #DDDFDE;
 
  text-align: center;
}
.nav-pills #butt1 a:hover,.nav-pills #butt1 a:focus {
  background-color: #97A09C;
}
::placeholder
{
	color: black;
}
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
.price
{
	display:inline-block;
}



.image-upload > input
{
    display: none;
}

.carousel, .carousel img {
  width: 300px;
}
.carousel img {
  height: 300px!important;
}


 p.name1{
	background-color:#c7b8b8;
	display: inline!important;
	padding:10px;
   
}
.selected{
	
	background: lightgrey;
}

#menu{
	
	
  padding:15px;
 


}

span{
	
	padding-right: 10px;
	
}
input,select{
	border-radius: 30px;
	
}
 span .name1{
	padding: 10px;
	
}

#profile img{
	align-content: center;
	
}


#profile{
	width:80%;
	height:800px;
	background-color:#c7b8b833
}
.name{
	background-color:#c7b8b8;
	padding:10px;
}
#profile p{


}

#container{
background-color: white;
margin-left: auto;
margin-right: auto;

}
span .name{
	padding: 10px;
	
}
#content{
	width:100%;
	height:100%;
	padding: 10px;
		
}

h1,h3{
	margin: 0px;
}

a{
	
	text-decoration: none;
	
}

#nav ul{
	list-style-type: none;
	padding: 0px;
}
#nav{
	
	width: 18%;
	float: left;
}
#main{
	
	width: 72%;
	float: left;
}

#nav .selected{
	font-weight: bold;
	
}

#header{
	
	background-color: black;
	color: white;
	text-align: center;
	padding: 10px;
}
  </style>
</head>
<body>

Welcome  ${user }
<nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<img src="/grizzle-store/images/logo.png">
</div>

<c:if test="${empty sessionScope.user }">
	<c:redirect url="/grizzle-store/app/home"></c:redirect>
	</c:if>

<div class="nav navbar-nav navbar-center"> <input type="text"  class="btn" style="outline:none;" name="search" placeholder="  Search..." id="t1"> <span class="glyphicon glyphicon-search" id="icon"></span> </div>

<ul class="nav navbar-nav navbar-right" id="t2"> <li id="bell"><i style="font-size:20px" class="fa" style="position:realtive; left:90px;">&#xf0f3;</i></li> <li id="bell" style="font-size:19px;">&nbsp;Welcome,<c:out value="${sessionScope.user.username}"></c:out></li> <li><a href="/grizzle-store/app/home"><input type="button"  class="btn" name="logout" value="logout" id="b1" ></a></li> </ul> </div> </nav>




  <div id="profile" style="position:relative; left:10px; width :100%;">
  <div class="container-fluid">
  <div class="row">
  
  
  <div class="col-sm-3">
  
  <div class="well" style="height:550px;">
  
  
  
  
  <div id="profile" style="background-color:grey; height:50px;">
    
    <div class="row">

    <div class="col-sm-6" style="padding-left:30px; padding-top:5px">PROFILE</div>

   
  </div>
  
  </div>
  
  
  <div style="text-align:center; padding:5px;">
  <img src="/grizzle-store/images/${sessionScope.user.username}.PNG" height="180px" width="150px">
    <p style="font-size:19px;margin-top:10px;">${sessionScope.user.userid}</p>
  <p style="font-size:19px;margin-top:10px;">${sessionScope.user.username}</p>
  <p style="font-size:15px; font-weight:bold;">Address</p>
   <c:out value="${sessionScope.user.address}"></c:out>
  </div>
  </div>
  </div>

  


 
<div class="col-sm-9" style="padding:20px;">
  <ul class="nav nav-pills">
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#product" style="color:black; font-weight:bold;">PRODUCTS</a></li>
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#vendors" style="color:black; font-weight:bold;">VENDORS</a></li>
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#category" style="color:black; font-weight:bold;"></a></li>
    
  </ul>

 
  <div class="tab-content">
    <div id="product" class="tab-pane fade in active">
    <div class="row">
    <div class="col-sm-4" style='padding-top: 20px;'>
    
    <p style="font-size:15px;"><img src="/grizzle-store/images/star1.JPG" style="width:18px;height:20px;"></p>
    </div>
    
  
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height:500px;">
 
     
     
     <div id="activity" style="padding: 20px;">
   <form action="/grizzle-store/app/viewProduct1" method="post">
   
   
   
   
  <table style="float: left;padding-right: 50px;">
<tr><td>
<c:set  var="myCarousel" value="myCarousel" ></c:set>
<div class="col-md-6 col-sm-6">
  <div id="myCarousel${product.productId }" class="carousel slide">
    <div class="carousel-inner">
    
     <c:set var="img" value="${fn:split(product.image, ',')}" />
      <div class="item active">
        <img src="/grizzle-store/images/${img[0]}">
      </div>
        <c:forTokens items="${product.image}" delims="," var="img">
   
         <div class="item">
         <img src="/grizzle-store/images/${img}">
         </div>
         </c:forTokens>      
 
    </div>
    <a class="left carousel-control" href="#myCarousel${product.productId }" data-slide="prev">
      <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel${product.productId }" data-slide="next">
      <span class="icon-next"></span>
    </a>
  </div>
</div>
</td>
</tr></table>

 <table style="float: left;padding-right: 50px;">
<tr>
<td><input type="text" id="productName" name="productName" placeholder="Product Name" value="${product.productName }"></td>
</tr>
<tr >
<td >

 <p style="height: 50px;width: 120px;">${product.productDescription}</p>
 
<tr>
<td> <input type="text" id="productPrice" placeholder="Product Price" name="productPrice" value="Rs:${product.productPrice }" ></td>
</tr>


   </table>  
       <tr><td><input type="submit" name="Back" value="Back"></td></tr>
   </form>
     
     </div>
     
 
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="buttons" style=" display:inline-block;">

    <form action="/grizzle-store/app/viewProduct1" method="post">
    <input type="submit" name="Finish" value="Finish" class='btn' style="background-color:#414141;color:white;font-weight:bold;border-radius:50px;width:150px;height:40px;font-weight:bold;outline: none;">
    </form>
    <form action="/grizzle-store/app/home">
    <input type="submit" name="Close" value="Close" class='btn' style="margin-top:20px;background-color:#C5C5C5;color:white;font-weight:bold;border-radius:50px;width:150px;height:40px;font-weight:bold;outline: none;">
    </form>
    </div>    
    </div>
    
    </div>  
    </div>
    <div id="vendors" class="tab-pane fade">
      <p></p>
    </div>
    
    <div id="category" class="tab-pane fade">
      <p></p>
    </div>

  </div>
 </div> 
 
</div>
</div>
</div>


</body>
</html>
    