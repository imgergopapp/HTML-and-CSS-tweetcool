package com.codecool.web.servlet;

import com.codecool.web.model.Tweet;
import com.codecool.web.service.FormValidator;
import com.codecool.web.service.InvalidFormException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/new-tweet")
public class NewTweetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String poster = request.getParameter("poster");
        String content = request.getParameter("content");

        try{
            FormValidator.formCheck(poster,content);
            Tweet newTweet = new Tweet(poster,content);
            Tweet.addToTweetList(newTweet);
            response.sendRedirect("welcome");
        }
        catch (InvalidFormException ife){
            response.sendRedirect("error");
        }


    }
   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }*/
}
