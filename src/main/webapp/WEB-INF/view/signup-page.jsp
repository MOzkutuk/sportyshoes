<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--

* Project: sportysho

* Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>signup</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="Webflow" name="generator">
    <link type="text/css" rel="stylesheet" href="css/web-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/normal-stylesheet.css">
</head>
<body>
<div class="form-block w-form ">

    <form:form method="post" modelAttribute="customer" >

        <label for="name">First name</label>
        <form:input path="name" type="text" class="w-input" name="name"  placeholder="Enter your name"
               id="name"/>
        <form:errors path="name" cssClass="addErrorMessage"/>


        <label for="surname">Last name</label>
        <form:input path="surname" type="text" class="w-input" name="surname"
               placeholder="Enter your last name" id="surname" />
        <form:errors  path="surname" cssClass="addErrorMessage"/>


        <label for="addressLine1">Addres line 1</label>
        <form:input path="contactDetails.addressLine1" type="text" class="w-input" name="addressLine1"
               placeholder="Enter your address" id="addressLine1" />
        <form:errors  path="contactDetails.addressLine1" cssClass="addErrorMessage"/>



        <label for="addressLine2">Addres line 2</label>
        <form:input path="contactDetails.addressLine2" type="text" class="w-input" maxlength="256" name="field-2"
               placeholder="Enter your address" id="addressLine2"/>
        <form:errors  path="contactDetails.addressLine2" cssClass="addErrorMessage"/>

        <label for="city">City</label>
        <form:input path="contactDetails.city" type="text" class="w-input"  name="cityv"
               placeholder="Enter your city" id="city" />
        <form:errors  path="contactDetails.city" cssClass="addErrorMessage"/>



        <label for="country">Country</label>
        <form:input path="contactDetails.country" type="text" class="w-input"  name="country"
               placeholder="Enter your country" id="country" />
        <form:errors  path="contactDetails.country" cssClass="addErrorMessage"/>



        <label for="postCode">Post code</label>
        <form:input path="contactDetails.postalCode" type="text" class="w-input"  name="postCode"
               placeholder="Enter your post code" id="postCode" />
        <form:errors path="contactDetails.postalCode" cssClass="addErrorMessage"/>



        <label for="email">Email</label>
        <form:input path="contactDetails.emailAddress" type="text" class="w-input"  name="email"
               placeholder="Enter your email ex: example@gmail.com" id="email"/>
        <form:errors path="contactDetails.emailAddress" cssClass="addErrorMessage"/>



        <label for="phoneNumber">Phone number</label>
        <form:input path="phone" type="text" class="w-input"  name="phoneNumber"
               placeholder="Enter your phone number ex: 48-123456789" id="phoneNumber" />
        <form:errors path="phone.mobileNumber" cssClass="addErrorMessage"/>
        <form:errors path="phone.countryCode" cssClass="addErrorMessage"/>



        <label for="username">Username</label>
        <form:input path="login.username" type="text" class="w-input"  name="username"
               placeholder="Enter your username ex: username123!" id="username" />
        <form:errors  path="login.username" cssClass="addErrorMessage"/>



        <label for="password">Password</label>
        <form:password path="login.password" class="w-input"  name="password"
               placeholder="Enter your password ex: pswrd123!" id="password" />
        <form:errors path="login.password" cssClass="addErrorMessage"/>


        <input type="submit" value="Sign up" data-wait="Please wait..." class="w-button">

    </form:form>

</div>
</body>
</html>