package com.codecool.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet {

    private String poster;
    private String content;
    private Date timestamp;
    private static int id;

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

    @Override
    public String toString() {
        return "Tweet{" +
            "poster='" + poster + "  " +
            ", content='" + content + "  " +
            ", timestamp=" + timestamp +
            '}';
    }
}

