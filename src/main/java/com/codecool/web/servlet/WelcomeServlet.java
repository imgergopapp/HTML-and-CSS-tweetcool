package com.codecool.web.servlet;

import com.codecool.web.model.ExceptionMsg;
import com.codecool.web.model.Tweet;
import com.codecool.web.service.XmlParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"", "/welcome"})
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletContext().getRealPath("data.xml");
        String redirectUrl = "welcome.jsp";
        try {
            Tweet.setTweetList(XmlParser.read(path));
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

        req.getRequestDispatcher(redirectUrl).forward(req, resp);
    }
}

