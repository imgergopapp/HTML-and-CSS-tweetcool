package com.codecool.web.servlet;

import com.codecool.web.model.Tweet;
import com.codecool.web.service.SearchFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search-filter")
public class SearchFilterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String limit = request.getParameter("limit");
        String offset = request.getParameter("offset");
        String poster = request.getParameter("poster");
        String from = request.getParameter("from");

        Tweet.setFilteredTweetList(SearchFilter.Filter(limit,offset,poster,from));

        response.sendRedirect("search-filter");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tweetList", Tweet.getFilteredTweetList());
        req.getRequestDispatcher("tweets.jsp").forward(req, resp);
    }
}
