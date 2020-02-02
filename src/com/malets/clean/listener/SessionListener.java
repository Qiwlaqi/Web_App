package com.malets.clean.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println(se.getName() + "added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println(se.getName() + "removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
