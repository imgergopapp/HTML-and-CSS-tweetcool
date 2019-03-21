package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchFilter {


    public static List<Tweet> Filter(String limit, String offset, String poster, String date) {

        List<Tweet> tweets = Tweet.getTweetList(); //Shallow copy
        List<Tweet> searchResult = new ArrayList<>();

        int i = offset.equals("") ? 0 : Integer.valueOf(offset);
        int count = limit.equals("") ? 10 : Integer.valueOf(limit);
        int maxRange = count > tweets.size() ? tweets.size() : count;

        int counter = 0;

        while (counter < maxRange) {
            String tempName = tweets.get(i).getPoster();
            Date tempDate = tweets.get(i).getTimestamp();

            if (!poster.equals("") && poster.equals(tempName) && !date.equals("") && compareDates(date, tempDate)) { //n : 1 | d : 1
                searchResult.add(tweets.get(i));
            } else if (!poster.equals("") && poster.equals(tempName) && date.equals("")) {//n : 1 | d : 0
                searchResult.add(tweets.get(i));
            } else if (poster.equals("") && !date.equals("") && compareDates(date, tempDate)) {// n : 0 | d : 1
                searchResult.add(tweets.get(i));
            } else if (poster.equals("") && date.equals("")) { // n : 0 | d : 0
                searchResult.add(tweets.get(i));
            }
            i++;
            counter++;
        }
        return searchResult;
    }

    private static boolean compareDates(String dateString, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        Date formattedDate = null;

        //YYYY.MM.dd
        String[] dateArray = dateString.split("-");

        //MM.dd.YYYY
        try {
            String s = dateArray[1] + "." + dateArray[2] + "." + dateArray[0];
            formattedDate = sdf.parse(s);
        } catch (ParseException pe) {
        }

        return date.getTime() > formattedDate.getTime();
    }
}
