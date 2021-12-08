package com.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String money = request.getParameter("money");
        Cookie cookie01 = new Cookie("user_name",userName);
        Cookie cookie02 = new Cookie("money",money);
        response.addCookie(cookie01);
        response.addCookie(cookie02);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index1.html");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
