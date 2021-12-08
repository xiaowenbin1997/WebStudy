package com.example.cookie;

import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jiaoZiMoney = 30;
        int mianTiaoMoney = 20;
        int gaiFanMoney = 15;
        //balance记录余额
        Double balance = 0.0;
        String food = request.getParameter("food");
        Map<String,String> cookieMap = new HashMap<>();
        Cookie[] requestCookies = request.getCookies();
        //得到cookieMap
        for (Cookie cookie : requestCookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            cookieMap.put(name,value);
        }
        String userName = cookieMap.get("user_name");
        balance = Double.valueOf(cookieMap.get("money"));
        switch (food){
            case "饺子":
                balance -= jiaoZiMoney;
                break;
            case "面条":
                balance -= mianTiaoMoney;
                break;
            case "盖饭":
                balance -= gaiFanMoney;
                break;
        }

        System.out.println("取出cookies");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
