package com.example.ServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁");
    }
}
