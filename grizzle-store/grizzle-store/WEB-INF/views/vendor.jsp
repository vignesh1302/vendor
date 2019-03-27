<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.*,com.cognizant.grizzlystore.model.*,com.cognizant.grizzlystore.model.UserDetails,com.cognizant.grizzlystore.dao.ProductDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navigation page : vendor</title>

<meta name="viewport" content="width=device-width, initial-scale=1">  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  #b1
{
       border-radius:50px;
       width:100px;
       /*height:30px;*/

       background-color:#D1C6C6;
       color:black;
  outline:none;
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
       top:95px;
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
.nav-pills>li>a:hover
{
       background-color:black;


}

.container {
  display: block;
  position: relative;
  padding-left: 5px;
  margin-bottom: 2px;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}


.checkmark {
  position: absolute;
  top: 5px;
  left: -80px;
  height: 18px;
  width: 18px;
  background-color: #eee;
  border-radius:50px;
}

.container:hover input ~ .checkmark {
  background-color: #ccc;
}

.container input:checked ~ .checkmark {
  background-color: black;
}

.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}


.container input:checked ~ .checkmark:after {
  display: block;
}


.container .checkmark:after {
  left: 9px;
  top: 5px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}


.nav-pills #butt1 a
{
  background-color: #DDDFDE;

  text-align: center;
}
.nav-pills #butt1 a:hover,.nav-pills #butt1 a:focus {
  background-color: #97A09C;
}
input:focus
{
  outline: none;
}
button:focus
{
  outline:none;
}

.dropdown button:focus
{
  outline:none;
}
  .tablep {
             border-collapse: collapse;
              }
              .tablep td {
              border: 1px solid #979797; 
              }
              .tablep tr:first-child td {
              border-top: 0;
              }
              .tablep tr td:first-child {
              border-left: 0;
              }
              .tablep tr:last-child td {
              border-bottom: 0;
              }      
              .tablep tr td:last-child {
              border-right: 0;
              } 
              .buttons{
              margin-left:20px; margin-right: 20px;
              border: none;
              border-radius:20px;
              width:20%;
              height:20px;
              Background-color:#E6E6E6;} 
  </style>
</head>
<body>
<c:if test="${empty message }"> <p style="color: green">	<c:out value="${message }"></c:out></p>
	</c:if>
	
<c:if test="${empty error }">
<p style="color: red">	<c:out value="${error }"></c:out></p>
	</c:if>
	

	
<%-- <c:if test="${empty sessionScope.user }"> --%>
<%-- 	<c:redirect url="/jsp/login1.jsp"></c:redirect> --%>
<%-- 	</c:if> --%>

<nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<img src="/grizzle-store/images/logo.png">
</div>

<div class="nav navbar-nav navbar-center"> <input type="text"  class='btn' style="outline:none;" name="search" placeholder="  Search..." id="t1"> <span class="glyphicon glyphicon-search" id="icon"></span> </div>

<ul class="nav navbar-nav navbar-right" id="t2"> <li id="bell"><i style="font-size:20px" class="fa" style="position:realtive; left:90px;">&#xf0f3;</i></li> <li id="bell" style="font-size:19px;">&nbsp;Welcome,<c:out value="${sessionScope.user.username}"></c:out></li> <li><a href="/grizzle-store/app/home"><input class='btn' type="button"  name="logout" value="logout" id="b1" ></a></li> </ul> </div> </nav>




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
    <li id="butt1" class="col-sm-3"> <form action="/cts/app/vendorProduct">
    <input type="submit" class="col-sm-3" style="color:black; font-weight:bold;" name="Vendor"value="VENDOR"> 
    </form></li>
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#category" style="color:black; font-weight:bold;"></a></li>
    
  </ul>
  


  <div class="tab-content">
    <div id="product" class="tab-pane fade in active">
       <br>
     	 <c:if test="${!empty message }">
<p style="color: green">	<c:out value="${message }"></c:out></p>
	</c:if>
	
<c:if test="${!empty error }">
<p style="color: red">	<c:out value="${error }"></c:out></p>
	</c:if>
    <table>
    <tr>
    <td>
    <div class="dropdown" style="padding:8px;">
    <button  class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"style="border-radius:50px;font-weight:bold;background-color:#E5E5E5;height:30px;color:#5A5858;outline:none;" >choose action
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">add</a></li>
      <li><a href="#">view</a></li>
      <li><a href="#">block</a></li>
    </ul>
  </div>
    </td>
    <td>
    <input type="text" style="border-radius:50px;background-color:#E5E5E5;height:30px;margin-left:50px;color:#5A5858;font-weight:bold;" placeholder=" category name">
    <span class="glyphicon glyphicon-search" id="icon2"></span>
    </td>
    <td>
    <div class="dropdown" style="padding:8px;">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"style="border-radius:50px;font-weight:bold;background-color:#E5E5E5;height:30px;margin-left:50px;color:#5A5858;outline:none;">sort by
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">BRAND</a></li>
      <li><a href="#">CATEGORY</a></li>
      <li><a href="#">RATING</a></li>
    </ul>
  </div>
    </td>
    <td>
    <form action="/cts/app/addProduct">
    <input type="submit" class='btn'style="border-radius:50px;width:130px;height:30px; margin-left:200px; background-color:#5A5858; font-weight:bold;color:white;outline: none;" name="Add"value="ADD PRODUCT"> 
    </form>
    </td>
    </tr>
    </table >
      
      <table class="table table-bordered" style="margin-top:10px;border-color:white;" class="col-sm-9">
     
      <form action="/grizzle-store/app/updateQuantity" method="post"> 
     
       <table class = "tablep"   style="width:100%;">
                     <tr class="heading" ><th></th>
                           <th >Vendor Product List</th><th>Brand</th><th>Category</th><th>Rating</th><th>Quantity</th><th>Quantity updation</th><th>&nbsp</th>
         
<tr>
 <c:if test="${fn:length(productList) <= 0}">
   <p style="color: red">Products are not available</p>
</c:if>
   <c:forEach items="${productList}" var="product">
    <tr>
     <td><input type="checkbox" name="productId"  value="${product.productId}">
   </td>
   <td>${product.productName}
   </td>
   
   <td>${product.productBrands.brandName}
   </td>
   <td>${product.productCategory.categoryName}
   </td>
   <td>${product.productRating}
   </td>
   <td>${product.vendorDetails.quantity}</td>
   <td><input type="number" name="quantity" ></td>
    <td><input type="submit" name="Update" value="Update">
   </td>
   </tr>
   </c:forEach>	
    </form>
</table>
      
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

