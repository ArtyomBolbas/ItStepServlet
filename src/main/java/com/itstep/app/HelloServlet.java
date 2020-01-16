package com.itstep.app;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HelloServlet extends HttpServlet {

    private static final String USER_NAME = "userName";
    private static final String CSS = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "    <style type=\"text/css\">\n" +
            "        /* Bordered form */\n" +
            "form {\n" +
            "  border: 3px solid #f1f1f1;\n" +
            "}\n" +
            "\n" +
            "/* Full-width inputs */\n" +
            "input[type=text], input[type=password] {\n" +
            "  width: 100%;\n" +
            "  padding: 12px 20px;\n" +
            "  margin: 8px 0;\n" +
            "  display: inline-block;\n" +
            "  border: 1px solid #ccc;\n" +
            "  box-sizing: border-box;\n" +
            "}\n" +
            "\n" +
            "/* Set a style for all buttons */\n" +
            "button {\n" +
            "  background-color: #4CAF50;\n" +
            "  color: white;\n" +
            "  padding: 14px 20px;\n" +
            "  margin: 8px 0;\n" +
            "  border: none;\n" +
            "  cursor: pointer;\n" +
            "  width: 100%;\n" +
            "}\n" +
            "\n" +
            "/* Add a hover effect for buttons */\n" +
            "button:hover {\n" +
            "  opacity: 0.8;\n" +
            "}\n" +
            "\n" +
            "/* Extra style for the cancel button (red) */\n" +
            ".cancelbtn {\n" +
            "  width: auto;\n" +
            "  padding: 10px 18px;\n" +
            "  background-color: #f44336;\n" +
            "}\n" +
            "\n" +
            "/* Center the avatar image inside this container */\n" +
            ".imgcontainer {\n" +
            "  text-align: center;\n" +
            "  margin: 24px 0 12px 0;\n" +
            "}\n" +
            "\n" +
            "/* Avatar image */\n" +
            "img.avatar {\n" +
            "  width: 40%;\n" +
            "  border-radius: 50%;\n" +
            "}\n" +
            "\n" +
            "/* Add padding to containers */\n" +
            ".container {\n" +
            "  padding: 16px;\n" +
            "}\n" +
            "\n" +
            "/* The \"Forgot password\" text */\n" +
            "span.psw {\n" +
            "  float: right;\n" +
            "  padding-top: 16px;\n" +
            "}\n" +
            "\n" +
            "/* Change styles for span and cancel button on extra small screens */\n" +
            "@media screen and (max-width: 300px) {\n" +
            "  span.psw {\n" +
            "    display: block;\n" +
            "    float: none;\n" +
            "  }\n" +
            "  .cancelbtn {\n" +
            "    width: 100%;\n" +
            "  }\n" +
            "}\n" +
            "  </style>\n" +
            "</head>\n" +
            "<body>";
    private static final String INPUT_VALUE = "<form action=\"HelloServlet\" method=\"post\">\n" +
            "    <div class=\"imgcontainer\">\n" +
            "        <img src=\"img_avatar2.png\" alt=\"Avatar\" class=\"avatar\">\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"container\">\n" +
            "        <label for=\"userName\"><b>Username</b></label>\n" +
            "        <input type=\"text\" placeholder=\"Enter Username\"";
    private static final String END = "name=\"userName\" required>\n" +
            "\n" +
            "        <label for=\"userPassword\"><b>Password</b></label>\n" +
            "        <input type=\"password\" placeholder=\"Enter Password\" name=\"userPassword\" required>\n" +
            "\n" +
            "        <button type=\"submit\">Login</button>\n" +
            "        <label>\n" +
            "            <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me\n" +
            "        </label>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"container\" style=\"background-color:#f1f1f1\">\n" +
            "        <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n" +
            "        <span class=\"psw\">Forgot <a href=\"#\">password?</a></span>\n" +
            "    </div>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Initialization of servlet");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("Hello from button");
        Cookie[] savedCookies = request.getCookies();
        Cookie myCookie = Arrays.stream(savedCookies)
                .filter(cookie -> cookie.getName().equalsIgnoreCase(USER_NAME))
                .findFirst()
                .orElse(null);
        String fullPage = CSS + INPUT_VALUE;
        if (myCookie != null) {
            fullPage += " value=\"" + myCookie.getValue() + "\" ";
        }
        fullPage += END;
        PrintWriter out = response.getWriter();
        out.println(fullPage);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet.doPost()");

        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter(USER_NAME);
        String userPassword = request.getParameter("userPassword");

        Cookie[] savedCookies = request.getCookies();
        Cookie myCookie = Arrays.stream(savedCookies)
                .filter(cookie -> cookie.getName().equalsIgnoreCase(USER_NAME))
                .findFirst()
                .orElse(null);
        System.out.println("Hello " + myCookie.getValue());

        Cookie ck=new Cookie(USER_NAME, userName);//creating cookie object
        response.addCookie(ck);//adding cookie in the response



        System.out.println(userName);
        System.out.println(userPassword);

        // response.setContentType("text/html");
        // response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<h3>Привет от MyServlet</h3> " + userName + " " + userPassword + "<br>");
        out.close();
    }

}
