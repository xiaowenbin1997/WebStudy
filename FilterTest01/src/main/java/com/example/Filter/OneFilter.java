package com.example.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Integer age = Integer.getInteger(servletRequest.getParameter("age"));
        if (age < 70) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.print("别看了，快跑");
        }
    }
}
