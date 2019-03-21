package com.codecool.web.servlet;

import com.codecool.web.model.ExceptionMsg;
import com.codecool.web.model.Tweet;
import com.codecool.web.service.FormValidator;
import com.codecool.web.service.InvalidFormException;
import com.codecool.web.service.XmlParser;

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
        String redirectUrl = "welcome";

        try {
            FormValidator.formCheck(poster, content);
        } catch (InvalidFormException ife) {
            String msg = "Invalid form ! Fill both name & tweet fields!";
            ExceptionMsg.setMsg(msg);

            redirectUrl="error";

        }
        Tweet newTweet = new Tweet(poster, content);
        String path = request.getServletContext().getRealPath("data.xml");

        try {
            XmlParser.write(newTweet, path);
        } catch (IOException ioe) {
            String msg = "Invalid data.xml! Make sure it's in the correct folder!";
            ExceptionMsg.setMsg(msg);

            redirectUrl="error";
        }
        catch (Exception e){
            String msg = "XmlParser Exception! ";
            ExceptionMsg.setMsg(msg);

            redirectUrl="error";
        }
        response.sendRedirect (redirectUrl);
    }
}
