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
            <a href="welcome">Welcome</a>
            <a href="tweets">Tweets</a>
        </div>
        <h1>Tweetcool</h1>

        <h2>Search Filter</h2>
        <form method="post" action="search-filter">
            <input type="number" placeholder="limit" name="limit">
            <input type="number" placeholder="offset" name="offset">
            <input type="text" placeholder="poster" name="poster">
            <input type="date" placeholder="from" name="from">
            <a href="tweets.html"> <input type="submit" value="submit"></a>
        </form>
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
