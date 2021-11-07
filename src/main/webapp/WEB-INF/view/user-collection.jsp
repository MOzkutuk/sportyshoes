<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--

* Project: sportysho

* Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="admin-header-user.jsp" %>
<html>
<head>
    <title>All Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
    <link rel="stylesheet" type="text/css" href="css/web-stylesheet.css">
    <link rel="stylesheet" type="text/css" href="css/normal-stylesheet.css">
    <link rel="stylesheet" type="text/css" href="css/search-form-stylesheet.css">
</head>
<body>
<h2 align="center">All Customer Data</h2>

<div class="container-2 footer">

    <table class="table">
        <thead class="table-dark">
        <tr>
            <td><b>Id</b></td>
            <td><b>First name</b></td>
            <td><b>Last name</b></td>
            <td><b>Username</b></td>
            <td><b>Password</b></td>
            <td><b>Country code</b></td>
            <td><b>Mobile</b></td>
            <td><b>Address line 1</b></td>
            <td><b>Address line 2</b></td>
            <td><b>City</b></td>
            <td><b>Country</b></td>
            <td><b>Zip code</b></td>
            <td><b>Email</b></td>
            <td><b>Cart Id</b></td>
        </tr>
        </thead>

        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><b>${customer.id}</b></td>
                <td><b>${customer.name}</b></td>
                <td><b>${customer.surname}</b></td>
                <td><b>${customer.login.username}</b></td>
                <td><b>${customer.login.password}</b></td>
                <td><b>${customer.phone.countryCode} ${customer.phone.mobileNumber}</b></td>
                <td><b>${customer.contactDetails.addressLine1}</b></td>
                <td><b>${customer.contactDetails.addressLine2}</b></td>
                <td><b>${customer.contactDetails.city}</b></td>
                <td><b>${customer.contactDetails.country}</b></td>
                <td><b>${customer.contactDetails.postalCode}</b></td>
                <td><b>${customer.contactDetails.emailAddress}</b></td>
                <td><b>${customer.cart.id}</b></td>
                <td><a class="btn btn-danger" href="deleteUser?id=${customer.id}"
                       onclick="if(!(confirm('Are you sure you want to delete this product ?')))return false">
                    Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
