<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Tweets</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="welcome">Welcome</a>
            <a href="tweets">Tweets</a>
        </div>
        <h1>Tweetcool</h1>
        <h2>Tweets</h2>
        <c:forEach items="${tweetList}" var="tweet">
            ${tweet}<br>
        </c:forEach>
    </body>
</html>
