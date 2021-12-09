package com.example.cookie;

import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = response.getWriter();
        Cookie[] requestCookies = request.getCookies();
        //得到cookieMap
        for (Cookie cookie : requestCookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            cookieMap.put(name,value);
        }
        Cookie newCookie = null;
        response.setContentType("text/html;charset=utf-8");
        String userName = cookieMap.get("user_name");
        balance = Double.valueOf(cookieMap.get("money"));
        switch (food){
            case "饺子":
                if (balance >= jiaoZiMoney) {
                    balance -= jiaoZiMoney;
                    newCookie = new Cookie("money",balance + "");
                } else {
                    out.print("用户" + userName + "余额不足");
                }
                break;
            case "面条":
                if (balance >= jiaoZiMoney) {
                    balance -= mianTiaoMoney;
                    newCookie = new Cookie("money",balance + "");
                } else {
                    out.print("用户" + userName + "余额不足");
                }
                break;
            case "盖饭":
                if (balance >= jiaoZiMoney) {
                    balance -= gaiFanMoney;
                    newCookie = new Cookie("money",balance + "");
                } else {
                    out.print("用户" + userName + "余额不足");
                }
                break;
            default:
                break;
        }
        response.addCookie(newCookie);
        out.print(food + "消费成功" + ",您的余额还剩" + balance + "元");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
