package com.malets.clean.util;

import java.util.Properties;

public class PoolManager {

    private final static Properties properties = new Properties();

    private PoolManager(){}

    public static Properties getProperties(){
        properties.put("user", "root");
        properties.put("password", "pass");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        return properties;
    }
}
