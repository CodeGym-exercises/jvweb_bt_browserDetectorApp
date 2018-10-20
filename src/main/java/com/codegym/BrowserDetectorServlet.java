package com.codegym;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BrowserDetectorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        PrintWriter writer = response.getWriter();

        String browser = "Unknow browser";

        if(userAgent.contains("Firefox")){
            browser = "Mozilla Firefox";
        } else if(userAgent.contains("OPR")){
            browser = "Opera";
        } else if(userAgent.contains("Safari")) {
            if(userAgent.contains("Chrome")){
                browser = "Google Chrome";
            } else {
                browser = "Apple Safari";
            }
        }

        writer.print("<html>\n" +
                "<head>\n" +
                "    <title>$Title$</title>\n" +
                "    <style>\n" +
                "        *{margin: 0;padding: 0;}\n" +
                "        .container{\n" +
                "            width: 55%;\n" +
                "            margin: 20px auto;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "<h1>Browser Detector</h1>" +
                "<h3>Your User-Agent Is: " + userAgent + "</h3>" +
                "<h3>Your Browser Is: " + browser + "</h3>"+
                "</div>\n" +
                "</body>\n" +
                "</html>");

    }
}
