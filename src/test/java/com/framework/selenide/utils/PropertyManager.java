package com.framework.selenide.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {


    public static String getUserPropertyValue(String key) {

        Properties property = new Properties();

        try(FileInputStream fis = new FileInputStream("src/test/resources/data/user.properties")){
            property.load(fis);

            return property.getProperty(key);
        } catch (IOException e) {
            System.err.println("File not found");
        }

        return null;
    }
}
