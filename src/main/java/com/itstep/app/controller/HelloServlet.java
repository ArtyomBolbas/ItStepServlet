package com.itstep.app.controller;

import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class HelloServlet extends HttpServlet {

    private ServletContext context;

    private static final String USER_NAME = "username";
    private static final String USER_PASSWORD = "password";

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.context = servletConfig.getServletContext();
        this.context.log("HelloServlet initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.context.log("HelloServlet GET - " + request.getRemoteAddr() + "; " +  this.getServletName() + "; " +  this.getServletInfo());
        /*Cookie[] cookies = request.getCookies();
        Cookie login = getCookie(cookies, USER_NAME);
        Cookie password = getCookie(cookies, USER_PASSWORD);
        if (login != null && !login.getValue().isEmpty()) {
            request.setAttribute(USER_NAME, login.getValue());

        }
        if (password != null && !password.getValue().isEmpty()) {
            request.setAttribute(USER_PASSWORD, password.getValue());
        }*/
        response.sendRedirect(request.getContextPath() + "/LoginController");
    }

    private Cookie getCookie(Cookie[] savedCookies, String nameCookie) {
        return Arrays.stream(savedCookies)
                .filter(cookie -> cookie.getName().equalsIgnoreCase(nameCookie))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.context.log("HelloServlet - " + request.getRemoteAddr() + "; " +  this.getServletName() + "; " +  this.getServletInfo());




        /*System.out.println("MyServlet.doPost()");

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
        out.close();*/
    }

}
