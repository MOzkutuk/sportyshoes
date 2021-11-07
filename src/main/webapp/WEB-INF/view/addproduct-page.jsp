<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--

* Project: sportysho

* Created By: Mehmet Baran Ozkutuk
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Add Product</title>
    <link type="text/css" rel="stylesheet" href="css/addproduct-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/main-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/normal-stylesheet.css">
    <link type="text/css" rel="stylesheet" href="css/web-stylesheet.css">
</head>
<body>

<div class="div-block">

    <h2 align="center">Add Product</h2>

    <div class="form-block-2 w-form">
        <form:form method="post" action="addProduct" modelAttribute="shoe" >
            <form:hidden path="id"/>

            <label>Shoe name</label>
            <form:input path="name"  class="w-input" placeholder="Enter shoe name" />
            <form:errors path="name" cssClass="addErrorMessage"/>


            <label for="brand">Brand name</label>
            <form:input path="brand"  class="w-input" placeholder="Enter brand name" />
            <form:errors path="brand" cssClass="addErrorMessage"/>


            <label for="price">Price($) </label>
            <form:input path="price"  class="w-input" placeholder="Enter price" />
            <form:errors path="price" cssClass="addErrorMessage"/>


            <label for="Size">Size(EU)</label>
            <form:input path="size"  class="w-input" placeholder="Enter sizze" />
            <form:errors path="size" cssClass="addErrorMessage"/>


            <input type="submit" value="Save" data-wait="Please wait..."
                   data-w-id="5ceea36d-8c13-2263-0cb2-e28652d30d1b" class="submit-button-2 w-button"/>

        </form:form>
    </div>
</div>
<div class="container w-container"></div>

</body>
</html>
