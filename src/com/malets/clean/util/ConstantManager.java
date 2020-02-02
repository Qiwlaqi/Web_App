package com.malets.clean.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConstantManager {

    public final static Properties properties;
    private static Logger logger = LogManager.getLogger();

    private ConstantManager(){}

    static {
        File file = new File("C:/USERS/USER/Desktop/Java Epam/FinalWebApp/src/resources/data.properties");
        properties = new Properties();
        try {
            properties.load(new FileReader(file));
            logger.log(Level.INFO, "Properties file is successfully read and loaded");
        } catch (IOException ex) {
            logger.log(Level.ERROR, "Error while opening file data.properties" + ex);
        }
    }
}
