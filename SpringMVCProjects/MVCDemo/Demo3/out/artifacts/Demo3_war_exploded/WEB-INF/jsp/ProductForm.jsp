<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
    <style type="text/css">@import url(/css/main.css);</style>
</head>
<body>
<div id="global">
    <c:if test="${requestScope.errors != null}">
        <p id="errors">
            Error(s)!
        <ul>
            <c:forEach var="error" items="${requestScope.errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>
        </p>
    </c:if>
    <form action="product_save.action" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Description: </label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input type="reset" id="reset" tabindex="4">
                <input type="submit" id="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
