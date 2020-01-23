package com.itstep.app.controller;

import com.itstep.app.service.ValidationService;
import com.itstep.app.service.ValidationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginController extends HttpServlet {

    private static final String USER_NAME = "username";
    private static final String USER_PASSWORD = "password";
    private final int ONE_HOUR = 600;

    private ValidationService validationService = new ValidationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello POST - LoginController - 1");
        Map<String, String[]> parameters = request.getParameterMap();

        String userName = parameters.get(USER_NAME)[0];
        String userPassword = parameters.get(USER_PASSWORD)[0];

        boolean isValidLogin = validationService.isValidLogin(userName);
        boolean isValidPassword = validationService.isValidPassword(userPassword);

        if (!isValidLogin || !isValidPassword) {
            response.sendRedirect(request.getContextPath());
            //request.getRequestDispatcher("index.jsp").forward(request,response);
            System.out.println("Hello POST - LoginController - params are empty");
        } else {
            createCookie(response, userName, userPassword);
            //request.getRequestDispatcher("showProducts.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/ShowProducts");
        }



        System.out.println("Hello POST - LoginController - 2");
    }

    private void createCookie(HttpServletResponse response, String login, String password) {
        Cookie loginCookie = new Cookie(USER_NAME, login);
        loginCookie.setMaxAge(ONE_HOUR);
        Cookie passwordCookie = new Cookie(USER_PASSWORD, password);
        response.addCookie(loginCookie);
        response.addCookie(passwordCookie);
    }



}
