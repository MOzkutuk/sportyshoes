<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--

* Project: sportysho

* Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in page</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link type="text/css" rel="stylesheet" href="css/login-page-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/web-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/normal-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
</head>
<body>

<div class="utility-page-wrap">
    <div class="utility-page-content w-password-page w-form">

        <form method="post" action="login" class="utility-page-form w-password-page"><img
                src="https://d3e54v103j8qbb.cloudfront.net/static/utility-lock.ae54711958.svg" alt="">

            <h2>Log in</h2>

            <label>Username</label>
            <input type="text" class="w-input" placeholder="Enter your username" required="required" name="username"/>
            <p class="addErrorMessage">${usernameError}</p>

            <label>Password</label>
            <input type="password" class="w-password-page w-input" required="required" placeholder="Enter your password" name="password"/>
            <p class="addErrorMessage">${passwordError}</p>

            <input type="submit" value="Log in" class="w-password-page w-button">
            <a href="signup" class="button w-button">Sing up</a>

        </form>
    </div>
</div>

</body>
</html>
