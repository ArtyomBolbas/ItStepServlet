package com.itstep.app.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShowProducts extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello GET");
        Map<String, Integer> persons = new HashMap<>();
        persons.put("Mary", 25);
        persons.put("Max", 18);
        persons.put("Joanna", 25);

        request.setAttribute("persons", persons);
        request.getRequestDispatcher("showProducts.jsp").forward(request, response);
    }
}
