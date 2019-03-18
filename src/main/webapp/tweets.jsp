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
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Poster</th>
                <th>Content</th>
                <th>Date</th>
            </tr>
            <c:forEach items="${tweetList}" var="tweet">
                <tr>
                    <td>
                        ${tweet.id}<br>
                    </td>
                    <td>
                        ${tweet.poster}<br>
                    </td>
                    <td>
                        ${tweet.content}<br>
                    </td>
                    <td>
                        ${tweet.timestamp}<br>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
