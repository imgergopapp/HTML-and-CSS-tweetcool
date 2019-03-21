<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="topnav">
                    <a href="welcome">Welcome</a>
                    <a href="tweets">Tweets</a>
        </div>
        <h1>Tweetcool</h1>
        <h2>Post your tweet here !</h2>
        <form method="post" action="new-tweet" id="tweetform">
            <input type="text" placeholder="Your name" name="poster">
            <a href="tweets.html"> <input type="submit" value="submit"></a>
        </form>
        <br>
        <textarea name="content" placeholder="Your tweet" rows="4" cols="50" form="tweetform"></textarea>
    </body>
</html>
