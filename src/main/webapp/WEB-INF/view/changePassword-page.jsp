<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--

* Project: sportysho

* Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="admin-header.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Change Password</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link type="text/css" rel="stylesheet" href="css/login-page-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/web-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/normal-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
</head>
<body>

<div class="utility-page-wrap">
    <div class="utility-page-content w-password-page w-form">

        <form method="post" action="changePassword" class="utility-page-form w-password-page"><img
                src="https://d3e54v103j8qbb.cloudfront.net/static/utility-lock.ae54711958.svg" alt="">

            <h2>Change Password</h2>

            <label>Password</label>
            <input type="password" class="w-password-page w-input" required="required" placeholder="Enter your new password" name="password"/>
            <p class="addErrorMessage">${notSaved}</p>

            <input type="submit" value="Change" class="w-password-page w-button">

        </form>
    </div>
</div>

</body>
</html>
