<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.cognizant.grizzlystore.model.UserDetails,com.cognizant.grizzlystore.dao.ProductDao,java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="/grizzle-store/css/style.css">
<style>
              body{
              font-size: 20px;
              font-color:#B3B3B3;
              font-family: Calibri,Candara,Segoe,Segoe UI,Optima,Arial,sans-serif; 
              }
              .searchbar {
           width: 100%;
           border-radius: 20px;
           border: none;
           border-bottom: 1px solid #ccc;
           font-size: 16px;
           background-color: none;
           background-image: url('../Images/searchicon.jpg');
           background-position: 10px 10px; 
           background-repeat: no-repeat;
           padding: 0px 0px 0px 15px;
           outline: none;
              }
              .logo{
              width:20%;
              }
              .search{
              width:20%;}
              .notification{
              width:20%;}
              .name{
              width:20;}
              .logout{
              width:20%;}
              .table{
              width:100%;
              broder: 0px solid;
              padding: 0px 0px 0px 0px;
              border:none;
              background-color:#F2F2F2;
              margin: 0px 0px 0px 0px;}
              .logoimg{
              width:100%;} 
              .btnlogout{
              border-radius:20px;
              border: 0px solid;
              background-color:#B3B3B3;
              height:30px;
              width:70px;
              }
              .btnadd{
              border-radius:20px;
              border: 0px solid;
              background-color:#B3B3B3;
              height:30px;
              width:70px;
              margin-right:0px
              }
              .btncancel{
              border-radius:20px;
              border: 0px solid;
              background-color:#B3B3B3;
              height:30px;
              width:70px;
              margin-right:20%;
              margin-left: 1350%;
              }
              .textfield{
              height: 35px;
              width: 80%;
              margin-left:20px;
              padding-left:20px;
              border:none;
              margin-top:0px;
              color:black;
              font-size:20px;
              border-bottom: 1px solid #676767;
              }
              .dropmenu{
              height: 35px;
              width: 90%;
              margin-left:20px;
              margin-top:0px;
              padding-left:20px;
              border:none;
              color:black;
              font-size:18px;
              border-bottom: 1px solid #676767;
              }
              .upload-btn-wrapper {
                position: relative;
                overflow: hidden;
                display: inline-block;
              }
              
              .btn {
                border: 2px solid gray;
                color: gray;
                background-color: white;
                padding: 8px 20px;
                border-radius: 8px;
                font-size: 20px;
                font-weight: bold;
              }
              
              .upload-btn-wrapper input[type=file] {
                font-size: 100px;
                position: absolute;
                width:100%;
                height:100%;
                left: 0;
                top: 0;
                right:0;
                bottom:0;
                opacity: 0;
              }      
              .page{
              text-color:#656565;
              width:100%;
              height:100%;
              text-align:center;} 
              .card{ box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
              max-width: 300px;
              height:100%;
              margin-left:0px ;
              text-align: center;}
              .heading{
              width:20%;
              height:20px;
              }      
             
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<c:if test="${empty sessionScope.user }">
     <c:redirect url="/jsp/login1.jsp"></c:redirect>
     </c:if>
<table class="table">
       <tr>
              <th class="logo"><img src="/grizzle-store/images/logo.png" class="logoimg"></th>
              <th class="search"><form>
              <input type="text" name="search" placeholder="Search" class = "searchbar">
              </form></th>
              <th class="name">Welcome,<c:out value="${sessionScope.user.username}"></c:out></th>
              <th class="logout">
                     <form action="/grizzle-store/app/home">
                     <input type="submit" value="Logout" class="btnlogout">
                    </form>
              </th>
       </tr>
</table><br><br>
<table class="page" >
       <tr style="width:100%; height:60%;">
              <td style="width:20%; height:100%; padding:0px;"> 
                     <div class="card" style="background-color:#F2F2F2;">
                     <div style = "background-color:#CDCDCD;width:100%; color:white;">
                      <img src="/grizzlystore/images/${sessionScope.user.username}.PNG" height="180px" width="150px">
                           <p style="font-size:19px;margin-top:10px;">${sessionScope.user.userid}</p>
                                <p style="font-size:19px;margin-top:10px;">${sessionScope.user.username}</p>
                                <p style="font-size:15px; font-weight:bold;">Address</p>
                                <c:out value="${sessionScope.user.address}"></c:out>
                    </div>
              </td>
              <td style="width:80%; vertical-align:top;" >
              <table style="width:100%; height:20%; vertical-align:top; ">
              <tr style="broder: 0px; font-size:30px; font-weight:100; padding:10px 10px 10px 10px;">
                     <th style="background-color:#B4B4B4; width:33%;text-align:left; box-shadow: 10px 10px solid black;">PRODUCTS</th>
                     <th style="background-color:#E6E6E6; width:33%;text-align:left;">VENDORS</th>
                     <th style="background-color:#F2F2F2;width:34%;text-align:left;"></th>
              </tr>
              </table>
              <br>
  <form action="/grizzle-store/app/saveproduct" method="post">     
  <table style="float: left;padding-right: 50px;">
<tr><td>
<div class="image-upload">
    <label for="file-input">
        <img src="/grizzle-store/images/img.JPG"/>
    </label>
    <input id="file-input" type="file" name="filenames" accept="image/x-png,image/gif,image/jpeg" multiple="multiple"/>
<hr>
</div>
</td>
</tr>
</table>
<table border="0" style="float: left">
              </td>
              <td>
              
              <input class="textfield" type="text" name="productName" placeholder="Product Name"><br>
              <select name="productBrands.brandId" class="dropmenu" id="brand">
                     <option>Brand</option>
                     <option value="1001">Philips</option>
                     <option value="1002">Apple</option>
                     <option value="1003">Sakura pigma</option>
                     <option value="1004">Braun</option>
                     <option value="1005">Copic</option>
              </select><br>
              <select name="productCategory.categoryId" class="dropmenu" id="category">
                     <option>Category</option>
                     <option value="101">Personal Care</option>
                     <option value="102">Laptops</option>
                     <option value="103">Art Supplies</option>
                     <option value=""></option>
              </select><br>
              <input class="textfield" type="text" name="productDescription" placeholder="Description"><br>
              <input class="textfield" type="text" name="productPrice" placeholder="Price"><br>
              </td>
              <td style="vertical-align:bottom">
              <div class="logout">
                     <input type="submit" name="Add"  value="Add" class="btnadd">
              </div>
              </td>
              </table>
                 </form>
                
              </td>
       </tr>
</table>
<table>
              <td style="vertical-align:bottom">

                   <form action="/grizzle-store/app/home">
                <td> <input type="submit" name="Cancel" value="Cancel" class="btncancel"></td>
                     </form>
                     </table>
              </div>
              </td>
              </table>
               

</body>
</html>

