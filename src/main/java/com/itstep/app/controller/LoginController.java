package com.itstep.app.controller;

import com.itstep.app.service.ValidationService;
import com.itstep.app.service.ValidationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ServletContext context;

    private static final String USER_NAME = "username";
    private static final String USER_PASSWORD = "password";
    /*
    private final String userID = "admin";
    private final String password = "password";
    */
    private final int ONE_HOUR = 600;

    private ValidationService validationService = new ValidationServiceImpl();


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.context = servletConfig.getServletContext();
        this.context.log("LoginController initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.context.log("LoginController GET - " + request.getRemoteAddr() + "; " +  this.getServletName() + "; " +  this.getServletInfo());
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", request.getContextPath() + "/LoginController");
        //response.sendRedirect(request.getContextPath() + "/LoginController");
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.context.log("LoginController POST - " + request.getRemoteAddr() + "; " +  this.getServletName() + "; " +  this.getServletInfo());
        /*Map<String, String[]> parameters = request.getParameterMap();

        String userName = parameters.get(USER_NAME)[0];
        String userPassword = parameters.get(USER_PASSWORD)[0];*/

        // get request parameters for username and password
        String userName = request.getParameter(USER_NAME);
        String userPassword = request.getParameter(USER_PASSWORD);

        boolean isValidLogin = validationService.isValidLogin(userName);
        boolean isValidPassword = validationService.isValidPassword(userPassword);

        if (!isValidLogin || !isValidPassword) {
            this.context.log("LoginController POST - params are empty");
            response.sendRedirect(request.getContextPath());
            //request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
            this.context.log("LoginController POST - VALID");
            createCookie(response, userName, userPassword);
            //request.getRequestDispatcher("showProducts.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/ShowProducts");
        }
    }

    private void createCookie(HttpServletResponse response, String login, String password) {
        Cookie loginCookie = new Cookie(USER_NAME, login);
        loginCookie.setMaxAge(ONE_HOUR);
        Cookie passwordCookie = new Cookie(USER_PASSWORD, password);
        response.addCookie(loginCookie);
        response.addCookie(passwordCookie);
    }

}
