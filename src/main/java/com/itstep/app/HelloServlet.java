package com.itstep.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Initialization of servlet");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("secondName");
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();


        if(firstName != null && firstName != "") {
            session.setAttribute("firstName", firstName);
            context.setAttribute("firstName", firstName);
        }
        /*if(surName != null && surName != "") {
            session.setAttribute("surName", surName);
            context.setAttribute("surName", surName);
        }*/

        //session.setMaxInactiveInterval(5);

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("Request parameter: " + firstName + "<br>");
        out.println("Request parameter: " + surName + "<br>");
        out.println("Session parameter: " + session.getAttribute("firstName") + "<br>");
        out.println("Context parameter: " + context.getAttribute("firstName") + "<br>");
        out.println("<a href='http://localhost:8888/ITStep/index.jsp'>Назад<a/><br>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet.doPost()");

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("firstName");
        String surName = request.getParameter("secondName");

        System.out.println(name);
        System.out.println(surName);

        // response.setContentType("text/html");
        // response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<h3>Привет от MyServlet</h3> " + name + " " + surName + "<br>Again");
        out.close();
    }

}
