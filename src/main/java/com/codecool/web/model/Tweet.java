package com.codecool.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet {

    private String poster;
    private String content;
    private Date timestamp;
    private int id;

    private static int idCounter = 0;

    private static List<Tweet> tweetList = new ArrayList<>();

    public Tweet(String name, String message) {
        this.poster = name;
        this.content = message;
        timestamp = new Date();
        id = ++idCounter;
    }

    public static List<Tweet> getTweetList() {
        return tweetList;
    }

    public static void addToTweetList(Tweet tweet) {
        tweetList.add(tweet);
    }

    // Below methods used in tweets.jsp
    public String getPoster() {
        return poster;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }
}

