package com.itstep.app;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloServlet extends HttpServlet {

    private static final String USER_NAME = "userName";

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Initialization of servlet");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hello GET");
        Map<String, Integer> persons = new HashMap<>();
        persons.put("Mary", 25);
        persons.put("Max", 18);
        persons.put("Joanna", 25);

        request.setAttribute("persons", persons);
        request.getRequestDispatcher("showInfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello POST");
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
