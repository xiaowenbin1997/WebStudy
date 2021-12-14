package com.example.HttpSession;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Enumeration<String> names = session.getAttributeNames();
        System.out.println("商品名---数量");
        while (names.hasMoreElements()) {
            String goodsName = names.nextElement();
            Integer goodsNum = (Integer) session.getAttribute(goodsName);
            System.out.println(goodsName + "---" + goodsNum);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
