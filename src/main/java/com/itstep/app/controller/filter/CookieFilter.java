package com.itstep.app.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CookieFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Hello I'm CookieFilter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
        filterChain.doFilter(request, response);
        /*HttpSession session = req.getSession(false);

        if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
            this.context.log("Unauthorized access request");
            res.sendRedirect("login.jsp");
        }else{
            // pass the request along the filter chain
            filterChain.doFilter(request, response);
        }*/
    }
}
