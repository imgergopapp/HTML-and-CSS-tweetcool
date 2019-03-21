package com.codecool.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet {

    private String poster;
    private String content;
    private Date timestamp;
    private int id;

    private static List<Tweet> tweetList;
    private static List<Tweet> filteredTweetList = new ArrayList<>();

    public Tweet(String poster, String content) {
        this.poster = poster;
        this.content = content;
        timestamp = new Date();
        id = tweetList.size() == 0 ? 1 : tweetList.get(tweetList.size() - 1).getId() + 1;
    }

    public Tweet(String poster, String content, Date timestamp, int id) {
        this.poster = poster;
        this.content = content;
        this.timestamp = timestamp;
        this.id = id;
    }

    // Setters
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

    public static List<Tweet> getTweetList() {
        return tweetList;
    }

    public static List<Tweet> getFilteredTweetList() {
        return filteredTweetList;
    }

    // Getters
    public static void setTweetList(List<Tweet> tweetList) {
        Tweet.tweetList = tweetList;
    }

    public static void setFilteredTweetList(List<Tweet> filteredTweetList) {
        Tweet.filteredTweetList = filteredTweetList;
    }

}

