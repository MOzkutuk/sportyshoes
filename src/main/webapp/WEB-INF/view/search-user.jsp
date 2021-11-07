<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--

* Project: sportysho

* Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Search User</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link type="text/css" rel="stylesheet" href="css/login-page-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/web-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/normal-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
</head>
<body>

<div class="utility-page-wrap">
    <div class="utility-page-content w-password-page w-form">

        <form method="post" action="searchUser" class="utility-page-form w-password-page"><img
                src="images/question-logo.jpg" alt="">

            <h2>Search User</h2>

            <label>Username</label>
            <input type="text" class="w-input" placeholder="Enter your username" required="required" name="username"/>
            <p class="addErrorMessage">${usernameError}</p>


            <input type="submit" value="Search" class="w-password-page w-button">
            <a href="showUsers" class="button w-button">Go back</a>

        </form>
    </div>
</div>

</body>
</html>