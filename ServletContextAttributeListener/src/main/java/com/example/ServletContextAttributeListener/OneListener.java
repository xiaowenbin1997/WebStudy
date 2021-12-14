package com.example.ServletContextAttributeListener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class OneListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("新增");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("移除");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("替换");
    }
}
