<%@ page language="java" errorPage="/jsp/internalerror.jsp" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success page</title>
<link rel="stylesheet" type="text/css" href="/grizzle/css/style.css">

</head>
<body>

<c:if test="${empty sessionScope.user }">
	<c:redirect url="/jsp/login1.jsp"></c:redirect>
	</c:if>

<div id="container">
	
	<div id="header" style="background: #c7b8b8;">
	
	<img style="float: left" height="30px" width="100px" src="/grizzlystore/images/bulb.jpeg">
	<span><input type="search"  placeholder="search"></span> <a href="/grizzlystore/LogoutController" style="float: right">Logout</a>
	</div>
	
	<div id="content">
	
	<div id="nav">
	
	
	<div id="profile" align="center" >
	<p class="name">Profile   <a href="#">Edit</a></p>
	<p align="center">${sessionScope.user.username}</p>
	<img alt="" src="/grizzlystore/images/${sessionScope.user.username}.PNG" height="20%" width="80%" > 
	<p>${sessionScope.user.address}</p>
	
	</div>

	</div>
	
	</div>
	<div class="col-sm-9" style="padding:20px;">
  <ul class="nav nav-pills">
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#product" style="color:black; font-weight:bold;">PRODUCTS</a></li>
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#vendors" style="color:black; font-weight:bold;">VENDORS</a></li>
    <li id="butt1" class="col-sm-3"><a data-toggle="pill" href="#category" style="color:black; font-weight:bold;"></a></li>
    
  </ul>
	
     
    <span><input type="search"  placeholder="search"></span> 
	 
	<span><select name="action" id="action"  >
	<option value="">Choose action
                      	<option value="Remove">	remove
              			<option value="Block">block
						</select></span> 
	<span><input type="search"  placeholder="category Name"></span> 
	<span><select name="Brand" id="brand"  >
	<option value="">Sort by 
                      	<option value="price">	price
              			<option value="Brand">brand
						<option value="Category">category
						
				</select></span> <a href="/grizzlystore/jsp/add.jsp" >Add Product</a>
	
     
     <div id="activity" style="padding: 20px;">
   
     <c:if test="${!empty message }">
<p style="color: green">	<c:out value="${message }"></c:out></p>
	</c:if>
	
<c:if test="${!empty error }">
<p style="color: red">	<c:out value="${error }"></c:out></p>
	</c:if>
	
	
     
     </div>
     
    

	</div>
</body>
</html>