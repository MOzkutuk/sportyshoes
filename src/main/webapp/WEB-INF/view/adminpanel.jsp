<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--

 * Project: sportysho

 * Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="admin-header.jsp"%>
<html>
<head>
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
</head>
<body>
<h2 align="center">Products</h2>

<div class="container-2 w-container">
    <table class="table">
        <thead class="table-dark">
        <tr>
            <td><b>Shoe ID</b></td>
            <td><b>Shoe name</b></td>
            <td><b>Brand</b></td>
            <td><b>Size</b></td>
            <td><b>Price</b></td>
            <td><b></b></td>
            <td><b></b></td>
        </tr>
        </thead>

        <c:forEach var="item" items="${shoes}">
            <tr>
                <td><b>${item.id}</b></td>
                <td><b>${item.name}</b></td>
                <td><b>${item.brand}</b></td>
                <td><b>${item.size}</b></td>
                <td><b>${item.price}</b></td>
                <td><a class="btn btn-outline-primary" href="updateProduct?id=${item.id}"> Update</a></td>
                <td><a class="btn btn-danger" href="deleteProduct?id=${item.id}"
                       onclick="if(!(confirm('Are you sure you want to delete this product ?')))return false">
                    Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>