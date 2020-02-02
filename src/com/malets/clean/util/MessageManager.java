package com.malets.clean.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourceBundleEn = ResourceBundle.getBundle("/resources/pagecontent_en");
    private final static ResourceBundle resourceBundleDe = ResourceBundle.getBundle("/resources/pagecontent_de");
    //private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("/resources/pagecontent");

    private MessageManager(){}
    /*public static String getProperty(String key){
        return resourceBundle.getString(key);
    }*/

    public static String getProperty(String key, HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("language"));
        if (request.getSession().getAttribute("language") == "de"){
            return resourceBundleDe.getString(key);
        }
        return resourceBundleEn.getString(key);
    }
}
